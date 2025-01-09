package com.example.barchart.presentation.githubreposlist.model

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ViewModelStateFlow<T>(private val key: ViewModelKey, value: T) : MutableStateFlow<T> {
    /**
     * A snapshot of the replay cache.
     */
    override val replayCache: List<T>
        get() = TODO("Not yet implemented")

    /**
     * The number of subscribers (active collectors) to this shared flow.
     *
     * The integer in the resulting [StateFlow] is not negative and starts with zero for a freshly created
     * shared flow.
     *
     * This state can be used to react to changes in the number of subscriptions to this shared flow.
     * For example, if you need to call `onActive` when the first subscriber appears and `onInactive`
     * when the last one disappears, you can set it up like this:
     *
     * ```
     * sharedFlow.subscriptionCount
     *     .map { count -> count > 0 } // map count into active/inactive flag
     *     .distinctUntilChanged() // only react to true<->false changes
     *     .onEach { isActive -> // configure an action
     *         if (isActive) onActive() else onInactive()
     *     }
     *     .launchIn(scope) // launch it
     * ```
     *
     * Usually, [StateFlow] conflates values, but [subscriptionCount] is not conflated.
     * This is done so that any subscribers that need to be notified when subscribers appear do
     * reliably observe it. With conflation, if a single subscriber appeared and immediately left, those
     * collecting [subscriptionCount] could fail to notice it due to `0` immediately conflating the
     * subscription count.
     */
    override val subscriptionCount: StateFlow<Int>
        get() = TODO("Not yet implemented")

    /**
     * The current value of this state flow.
     *
     * Setting a value that is [equal][Any.equals] to the previous one does nothing.
     *
     * This property is **thread-safe** and can be safely updated from concurrent coroutines without
     * external synchronization.
     */
    override var value: T
        get() = TODO("Not yet implemented")
        set(value) {}

    /**
     * Resets the [replayCache] of this shared flow to an empty state.
     * New subscribers will be receiving only the values that were emitted after this call,
     * while old subscribers will still be receiving previously buffered values.
     * To reset a shared flow to an initial value, emit the value after this call.
     *
     * On a [MutableStateFlow], which always contains a single value, this function is not
     * supported, and throws an [UnsupportedOperationException]. To reset a [MutableStateFlow]
     * to an initial value, just update its [value][MutableStateFlow.value].
     *
     * This method is **thread-safe** and can be safely invoked from concurrent coroutines without
     * external synchronization.
     *
     * **Note: This is an experimental api.** This function may be removed or renamed in the future.
     */
    @ExperimentalCoroutinesApi
    override fun resetReplayCache() {
        TODO("Not yet implemented")
    }

    /**
     * Tries to emit a [value] to this shared flow without suspending. It returns `true` if the value was
     * emitted successfully (see below). When this function returns `false`, it means that a call to a plain [emit]
     * function would suspend until there is buffer space available.
     *
     * This call can return `false` only when the [BufferOverflow] strategy is
     * [SUSPEND][BufferOverflow.SUSPEND] **and** there are subscribers collecting this shared flow.
     *
     * If there are no subscribers, the buffer is not used.
     * Instead, the most recently emitted value is simply stored into
     * the replay cache if one was configured, displacing the older elements there,
     * or dropped if no replay cache was configured. In any case, `tryEmit` returns `true`.
     *
     * This method is **thread-safe** and can be safely invoked from concurrent coroutines without
     * external synchronization.
     */
    override fun tryEmit(value: T): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Emits a [value] to this shared flow, suspending on buffer overflow.
     *
     * This call can suspend only when the [BufferOverflow] strategy is
     * [SUSPEND][BufferOverflow.SUSPEND] **and** there are subscribers collecting this shared flow.
     *
     * If there are no subscribers, the buffer is not used.
     * Instead, the most recently emitted value is simply stored into
     * the replay cache if one was configured, displacing the older elements there,
     * or dropped if no replay cache was configured.
     *
     * See [tryEmit] for a non-suspending variant of this function.
     *
     * This method is **thread-safe** and can be safely invoked from concurrent coroutines without
     * external synchronization.
     */
    override suspend fun emit(value: T) {
        TODO("Not yet implemented")
    }

    /**
     * Atomically compares the current [value] with [expect] and sets it to [update] if it is equal to [expect].
     * The result is `true` if the [value] was set to [update] and `false` otherwise.
     *
     * This function use a regular comparison using [Any.equals]. If both [expect] and [update] are equal to the
     * current [value], this function returns `true`, but it does not actually change the reference that is
     * stored in the [value].
     *
     * This method is **thread-safe** and can be safely invoked from concurrent coroutines without
     * external synchronization.
     */
    override fun compareAndSet(expect: T, update: T): Boolean {
        TODO("Not yet implemented")
    }

    /**
     * Accepts the given [collector] and [emits][FlowCollector.emit] values into it.
     * To emit values from a shared flow into a specific collector, either `collector.emitAll(flow)` or `collect { ... }`
     * SAM-conversion can be used.
     *
     * **A shared flow never completes**. A call to [Flow.collect] or any other terminal operator
     * on a shared flow never completes normally.
     *
     * It is guaranteed that, by the time the first suspension happens, [collect] has already subscribed to the
     * [SharedFlow] and is eligible for receiving emissions. In particular, the following code will always print `1`:
     * ```
     * val flow = MutableSharedFlow<Int>()
     * launch(start = CoroutineStart.UNDISPATCHED) {
     *     flow.collect { println(1) }
     * }
     * flow.emit(1)
     * ```
     *
     * @see [Flow.collect] for implementation and inheritance details.
     */
    override suspend fun collect(collector: FlowCollector<T>): Nothing {
        TODO("Not yet implemented")
    }

}