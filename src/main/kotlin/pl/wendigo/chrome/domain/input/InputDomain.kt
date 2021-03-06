package pl.wendigo.chrome.domain.input

/**
 * InputDomain represents remote debugger protocol domain.
 */
class InputDomain internal constructor(private val connectionRemote : pl.wendigo.chrome.DebuggerProtocol) {
    /**
     * Dispatches a key event to the page.
     */
    fun dispatchKeyEvent(input : DispatchKeyEventRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Input.dispatchKeyEvent", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Dispatches a mouse event to the page.
     */
    fun dispatchMouseEvent(input : DispatchMouseEventRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Input.dispatchMouseEvent", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Dispatches a touch event to the page.
     */
    fun dispatchTouchEvent(input : DispatchTouchEventRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Input.dispatchTouchEvent", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Emulates touch event from the mouse event parameters.
     */
    fun emulateTouchFromMouseEvent(input : EmulateTouchFromMouseEventRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Input.emulateTouchFromMouseEvent", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Ignores input events (useful while auditing page).
     */
    fun setIgnoreInputEvents(input : SetIgnoreInputEventsRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Input.setIgnoreInputEvents", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
     */
    fun synthesizePinchGesture(input : SynthesizePinchGestureRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Input.synthesizePinchGesture", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
     */
    fun synthesizeScrollGesture(input : SynthesizeScrollGestureRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Input.synthesizeScrollGesture", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
     */
    fun synthesizeTapGesture(input : SynthesizeTapGestureRequest) : io.reactivex.Single<pl.wendigo.chrome.ResponseFrame> {
        return connectionRemote.runAndCaptureResponse("Input.synthesizeTapGesture", input, pl.wendigo.chrome.ResponseFrame::class.java).map {
            it.value()
        }
    }

    /**
     * Returns flowable capturing all Input domains events.
     */
    fun events() : io.reactivex.Flowable<pl.wendigo.chrome.ProtocolEvent> {
        return connectionRemote.captureAllEvents().map { it.value() }.filter {
            it.protocolDomain() == "Input"
        }
    }
}
/**
 * Represents request frame that can be used with Input.dispatchKeyEvent method call.
 *
 * Dispatches a key event to the page.
 */
data class DispatchKeyEventRequest (
    /**
     * Type of the key event.
     */
    val type : String,

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8
(default: 0).
     */
    val modifiers : Int? = null,

    /**
     * Time at which the event occurred.
     */
    val timestamp : TimeSinceEpoch? = null,

    /**
     * Text as generated by processing a virtual key code with a keyboard layout. Not needed for
for `keyUp` and `rawKeyDown` events (default: "")
     */
    val text : String? = null,

    /**
     * Text that would have been generated by the keyboard if no modifiers were pressed (except for
shift). Useful for shortcut (accelerator) key handling (default: "").
     */
    val unmodifiedText : String? = null,

    /**
     * Unique key identifier (e.g., 'U+0041') (default: "").
     */
    val keyIdentifier : String? = null,

    /**
     * Unique DOM defined string value for each physical key (e.g., 'KeyA') (default: "").
     */
    val code : String? = null,

    /**
     * Unique DOM defined string value describing the meaning of the key in the context of active
modifiers, keyboard layout, etc (e.g., 'AltGr') (default: "").
     */
    val key : String? = null,

    /**
     * Windows virtual key code (default: 0).
     */
    val windowsVirtualKeyCode : Int? = null,

    /**
     * Native virtual key code (default: 0).
     */
    val nativeVirtualKeyCode : Int? = null,

    /**
     * Whether the event was generated from auto repeat (default: false).
     */
    val autoRepeat : Boolean? = null,

    /**
     * Whether the event was generated from the keypad (default: false).
     */
    val isKeypad : Boolean? = null,

    /**
     * Whether the event was a system key event (default: false).
     */
    val isSystemKey : Boolean? = null,

    /**
     * Whether the event was from the left or right side of the keyboard. 1=Left, 2=Right (default:
0).
     */
    val location : Int? = null

)

/**
 * Represents request frame that can be used with Input.dispatchMouseEvent method call.
 *
 * Dispatches a mouse event to the page.
 */
data class DispatchMouseEventRequest (
    /**
     * Type of the mouse event.
     */
    val type : String,

    /**
     * X coordinate of the event relative to the main frame's viewport in CSS pixels.
     */
    val x : Double,

    /**
     * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to
the top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
     */
    val y : Double,

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8
(default: 0).
     */
    val modifiers : Int? = null,

    /**
     * Time at which the event occurred.
     */
    val timestamp : TimeSinceEpoch? = null,

    /**
     * Mouse button (default: "none").
     */
    val button : String? = null,

    /**
     * Number of times the mouse button was clicked (default: 0).
     */
    val clickCount : Int? = null,

    /**
     * X delta in CSS pixels for mouse wheel event (default: 0).
     */
    val deltaX : Double? = null,

    /**
     * Y delta in CSS pixels for mouse wheel event (default: 0).
     */
    val deltaY : Double? = null

)

/**
 * Represents request frame that can be used with Input.dispatchTouchEvent method call.
 *
 * Dispatches a touch event to the page.
 */
data class DispatchTouchEventRequest (
    /**
     * Type of the touch event. TouchEnd and TouchCancel must not contain any touch points, while
TouchStart and TouchMove must contains at least one.
     */
    val type : String,

    /**
     * Active touch points on the touch device. One event per any changed point (compared to
previous touch event in a sequence) is generated, emulating pressing/moving/releasing points
one by one.
     */
    val touchPoints : List<TouchPoint>,

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8
(default: 0).
     */
    val modifiers : Int? = null,

    /**
     * Time at which the event occurred.
     */
    val timestamp : TimeSinceEpoch? = null

)

/**
 * Represents request frame that can be used with Input.emulateTouchFromMouseEvent method call.
 *
 * Emulates touch event from the mouse event parameters.
 */
data class EmulateTouchFromMouseEventRequest (
    /**
     * Type of the mouse event.
     */
    val type : String,

    /**
     * X coordinate of the mouse pointer in DIP.
     */
    val x : Int,

    /**
     * Y coordinate of the mouse pointer in DIP.
     */
    val y : Int,

    /**
     * Time at which the event occurred.
     */
    val timestamp : TimeSinceEpoch,

    /**
     * Mouse button.
     */
    val button : String,

    /**
     * X delta in DIP for mouse wheel event (default: 0).
     */
    val deltaX : Double? = null,

    /**
     * Y delta in DIP for mouse wheel event (default: 0).
     */
    val deltaY : Double? = null,

    /**
     * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8
(default: 0).
     */
    val modifiers : Int? = null,

    /**
     * Number of times the mouse button was clicked (default: 0).
     */
    val clickCount : Int? = null

)

/**
 * Represents request frame that can be used with Input.setIgnoreInputEvents method call.
 *
 * Ignores input events (useful while auditing page).
 */
data class SetIgnoreInputEventsRequest (
    /**
     * Ignores input events processing when set to true.
     */
    val ignore : Boolean

)

/**
 * Represents request frame that can be used with Input.synthesizePinchGesture method call.
 *
 * Synthesizes a pinch gesture over a time period by issuing appropriate touch events.
 */
data class SynthesizePinchGestureRequest (
    /**
     * X coordinate of the start of the gesture in CSS pixels.
     */
    val x : Double,

    /**
     * Y coordinate of the start of the gesture in CSS pixels.
     */
    val y : Double,

    /**
     * Relative scale factor after zooming (>1.0 zooms in, <1.0 zooms out).
     */
    val scaleFactor : Double,

    /**
     * Relative pointer speed in pixels per second (default: 800).
     */
    val relativeSpeed : Int? = null,

    /**
     * Which type of input events to be generated (default: 'default', which queries the platform
for the preferred input type).
     */
    val gestureSourceType : GestureSourceType? = null

)

/**
 * Represents request frame that can be used with Input.synthesizeScrollGesture method call.
 *
 * Synthesizes a scroll gesture over a time period by issuing appropriate touch events.
 */
data class SynthesizeScrollGestureRequest (
    /**
     * X coordinate of the start of the gesture in CSS pixels.
     */
    val x : Double,

    /**
     * Y coordinate of the start of the gesture in CSS pixels.
     */
    val y : Double,

    /**
     * The distance to scroll along the X axis (positive to scroll left).
     */
    val xDistance : Double? = null,

    /**
     * The distance to scroll along the Y axis (positive to scroll up).
     */
    val yDistance : Double? = null,

    /**
     * The number of additional pixels to scroll back along the X axis, in addition to the given
distance.
     */
    val xOverscroll : Double? = null,

    /**
     * The number of additional pixels to scroll back along the Y axis, in addition to the given
distance.
     */
    val yOverscroll : Double? = null,

    /**
     * Prevent fling (default: true).
     */
    val preventFling : Boolean? = null,

    /**
     * Swipe speed in pixels per second (default: 800).
     */
    val speed : Int? = null,

    /**
     * Which type of input events to be generated (default: 'default', which queries the platform
for the preferred input type).
     */
    val gestureSourceType : GestureSourceType? = null,

    /**
     * The number of times to repeat the gesture (default: 0).
     */
    val repeatCount : Int? = null,

    /**
     * The number of milliseconds delay between each repeat. (default: 250).
     */
    val repeatDelayMs : Int? = null,

    /**
     * The name of the interaction markers to generate, if not empty (default: "").
     */
    val interactionMarkerName : String? = null

)

/**
 * Represents request frame that can be used with Input.synthesizeTapGesture method call.
 *
 * Synthesizes a tap gesture over a time period by issuing appropriate touch events.
 */
data class SynthesizeTapGestureRequest (
    /**
     * X coordinate of the start of the gesture in CSS pixels.
     */
    val x : Double,

    /**
     * Y coordinate of the start of the gesture in CSS pixels.
     */
    val y : Double,

    /**
     * Duration between touchdown and touchup events in ms (default: 50).
     */
    val duration : Int? = null,

    /**
     * Number of times to perform the tap (e.g. 2 for double tap, default: 1).
     */
    val tapCount : Int? = null,

    /**
     * Which type of input events to be generated (default: 'default', which queries the platform
for the preferred input type).
     */
    val gestureSourceType : GestureSourceType? = null

)

