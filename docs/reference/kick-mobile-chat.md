# Kick mobile app: chat internals (reference notes)

Static analysis of the official Android app, for checking our nobilis chat against it.

## Source analysed

| | |
|---|---|
| Package | `com.kick.mobile` ("KICK: Live Streaming") |
| Version | 40.32.1 (versionCode 60006965), min SDK 24, target SDK 37 |
| Format | XAPK from APKPure (main APK plus config splits) |
| Main APK SHA-256 | `41b45d80108c01b4bf2ceafb07cfe916e20d7b929bf5fff1d3b3e21470c4d83d` |
| Stack | React Native (Expo SDK 54). App logic is a **Hermes bytecode v99** bundle (`assets/index.android.bundle`), not Java. |

The APK itself is not committed (size and redistribution).

## Method and caveats

- jadx 1.5.6 decompiles only the native Java shell (SDKs, bridge modules). Chat logic is in the JS bundle.
- The bundle was decompiled with `hermes-dec` 0.1.7. It warns that v99 is not formally supported, so the
  output is approximate. Strings, constants, call targets and object keys are reliable. Control flow,
  register names and object-literal key *order* are not (for example `{'method':'POST','body':null}` followed by
  `r[2] = ...` assigns by position).
- Everything below is read from that output and has **not** been checked against live traffic. Confirm
  anything load-bearing with a capture before depending on it.

## Realtime transport (Pusher)

- Library: `pusher-websocket-react-native`. Init options: `maxReconnectionAttempts: 20`,
  `maxReconnectGapInSeconds: 10`, `authorizerTimeoutInSeconds: 20`, custom `onAuthorizer`, `onEvent`.
- `app_key` and `cluster` are read at runtime from an `apiConfiguration` object, not hard-coded in the
  bundle. The init throws if either is missing. Capture the config response to get them.
- Private/presence channel auth is **not** the Laravel `/broadcasting/auth` route. The mobile authorizer
  does `POST https://mobile.kick.com/api/v1/realtime/auth/channel` with body `{ channel }` (authenticated),
  and returns `{ auth, channel_data, shared_secret }` to Pusher.
  A sibling `/api/v1/realtime/auth/connection` also exists.
- Internal events handled: `pusher_internal:subscription_succeeded`, `pusher_internal:subscription_count`.

## Channel names

Seen as string prefixes concatenated with an id:

- `chatrooms.<id>.v2` (v2 chatroom channel; the code compares incoming event channels to this)
- `chatroom_<id>`, `channel_<id>`, `channel.<id>`
- `private-livestream.<id>`
- `livestream_started_<id>`

## Event names (full enum from the bundle)

Chat: `App\Events\ChatMessageEvent`, `ChatMessageSentEvent`, `ChatMessageDeletedEvent`, `MessageDeleted`,
`App\Events\MessageDeletedEvent`, `ChatMessageReact`, `ChatroomUpdatedEvent`, `ChatroomClearEvent`,
`ChatroomModeEvent`, `ChatMoveToSupportedChannelEvent`, `PinnedMessageCreatedEvent`, `PinnedMessageDeletedEvent`.

Moderation: `UserBannedEvent`, `UserUnbannedEvent`, `UserTimeouted`, `BannedUserAdded`, `BannedUserDeleted`,
`BannedWordAdded`, `BannedWordDeleted`, `ChannelBannedForceRefresh`.

Room modes: `SlowModeActivated/Deactivated`, `EmotesModeActivated/Deactivated`,
`FollowersModeActivated/Deactivated`, `SubscribersModeActivated/Deactivated`,
`MatureModeActivated/Deactivated`, `AllowLinksActivated/Deactivated`.

Subs/support: `SubscriptionCreated`, `SubscriptionRenewed`, `SubscriptionGifted`, `GiftedSubscriptionsEvent`,
`LuckyUsersWhoGotGiftSubscriptionsEvent`, `SubscriptionEvent`, `NewSubscriberUpdatedEvent`,
`ChannelSubscriptionEvent`, `GiftsLeaderboardUpdated`, `KicksGifted`, `KicksGiftedDeleted`,
`KicksBalanceUpdated`, `KicksLeaderboardUpdated`, `MintTransactionCompleted`.

Stream/channel: `StreamerIsLive`, `StartStream`, `StopStreamBroadcast`, `LivestreamUpdated`,
`LiveStream\UpdatedLiveStreamEvent`, `StreamHostEvent`, `StreamHostedEvent`, `HostReceived`, `TitleChanged`,
`CategoryChanged`, `FollowerAdded`, `FollowersUpdated`, `FollowersUpdatedForChannelOwner`,
`NotifyFollowersStreamHasStarted`, `ChannelActionEvent`, `ClipInitializedEvent`, `AddChannelUserEvent`.

Engagement: `PollUpdateEvent`, `PollDeleteEvent`, `PredictionCreated`, `PredictionUpdated`, `GoalCreatedEvent`,
`GoalUpdatedEvent`, `GoalProgressUpdateEvent`, `GoalAchievedEvent`, `GoalCanceledEvent`, `RewardRedeemedEvent`,
`PointsUpdated`, `GamificationLevelUp`, `GamificationWatchTimeGoalReached`, `drops_campaign_started`,
`Verification.Result`.

## REST: sending and deleting messages

- Send: `POST /api/v2/messages/send/<chatroomId>` (JSON body).
- Delete: `DELETE /api/v2/chatrooms/<chatroomId>/messages/<messageId>`.
- Body built by `createMessage({ messageContent, chatroomId, repliedMessage })`:
  - plain: `{ chatroomId, content: <trimmed>, type: "message" }`
  - reply: `{ chatroomId, content, type: "reply", metadata: { ... original message ... } }`
- The send mutation then adds a client-generated `message_ref` for optimistic UI and reconciliation.
- The code also references `original_message`, `sender`, `identity`, `badges`, `emotes`, `color`,
  `created_at`, `chatroom_id` while handling messages.

## Emote and message-text syntax

- Emotes in message content: `[emote:<id>:<name>]`. Message-content split regex:
  `(\[emote:\w+:[a-zA-Z0-9_-]{0,}\])|(@\w+)|(https:\/\/\w{1,}\.\w{1,}\S+)`
  (emote token, `@mention`, `https://` link) and a global emote matcher `\[emote:\w+:[a-zA-Z0-9_-]*\]`.
- When composing, typed `:name:` is rewritten to `[emote:<id>:<name>]` via `/:[a-zA-Z0-9_-]{1,}:/g`
  (only if the name resolves to a known emote).
- An RTL check (`[֑-߿יִ-﷽ﹰ-ﻼ]`) drives text direction.

## Other endpoints seen (chat-adjacent)

`/api/v2/chatrooms/`, `/api/v1/chat/`, `/api/v1/chatrooms/`, `/api/v2/channel-goal-emotes`,
`/api/v1/subscriptions/*`, `/api/v2/user/subscriptions`, `/api/v1/channels/user/(un)subscribe`,
`/api/v2/clips`, `/api/internal/v1/notifications/mobile/*`.

Hosts: `https://mobile.kick.com` (API), `https://chat.mobile.kick.com` (chat; an `ipAdressOverride` default),
`https://mobile.flags.kick.com` (feature flags), `https://search.kick.com`, `https://files.kick.com`,
`https://files.cdn.kick.com`, `https://clips.kick.com`, `https://ext.kick.com`.

## Correction / lead: Centrifugo is a second realtime transport

The app also ships a Kick-written native module `Kickcentrifugo` (`reference/kick-40.32.1/java/com/kick/centrifugo/`) wrapping
`io.github.centrifugal.centrifuge`. It takes `connectionUrl`, `connectionAuthUrl`, `channelAuthUrl` (+ headers) and emits
`onConnecting/onConnected/onDisconnected/onClientSubscribed/onClientPublication/onClientJoin/onClientLeave/onClientError`.
The `/api/v1/realtime/auth/connection` and `/api/v1/realtime/auth/channel` endpoints noted above for the Pusher authorizer may in fact
serve Centrifugo; which transport carries chat messages (Pusher, Centrifugo, or both during a migration) is **unconfirmed** and is the
first thing to settle before comparing nobilis. See also `reference/kick-40.32.1/DEPENDENCIES.md` (native libs are all third-party).

## Not yet done

- Compare against the nobilis chat implementation (not in this repo yet).
- Message and event JSON schemas (field names and types) need a live capture or deeper decompilation.
- Pusher `app_key`/`cluster` and what `chat.mobile.kick.com` serves.
