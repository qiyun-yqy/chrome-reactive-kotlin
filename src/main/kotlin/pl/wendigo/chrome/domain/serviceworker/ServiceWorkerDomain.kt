package pl.wendigo.chrome.domain.serviceworker

/**
 * ServiceWorkerDomain represents remote debugger protocol domain.
 *
 * This class was autogenerated by main.go. Do not edit :)
 */
@pl.wendigo.chrome.ProtocolExperimental class ServiceWorkerDomain internal constructor(private val connection : pl.wendigo.chrome.RemoteChromeConnection) {

	/**
	 * 
	 */
	  fun enable() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.enable", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun disable() : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.disable", null, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun unregister(input : UnregisterRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.unregister", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun updateRegistration(input : UpdateRegistrationRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.updateRegistration", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun startWorker(input : StartWorkerRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.startWorker", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun skipWaiting(input : SkipWaitingRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.skipWaiting", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun stopWorker(input : StopWorkerRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.stopWorker", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun inspectWorker(input : InspectWorkerRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.inspectWorker", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun setForceUpdateOnPageLoad(input : SetForceUpdateOnPageLoadRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.setForceUpdateOnPageLoad", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun deliverPushMessage(input : DeliverPushMessageRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.deliverPushMessage", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

	/**
	 * 
	 */
	  fun dispatchSyncEvent(input : DispatchSyncEventRequest) : io.reactivex.Flowable<pl.wendigo.chrome.GenericResponse> {
        return connection.runAndCaptureResponse("ServiceWorker.dispatchSyncEvent", input, pl.wendigo.chrome.GenericResponse::class.java)
	}

  
  /**
   * 
   */
   fun onWorkerRegistrationUpdated() : io.reactivex.Flowable<WorkerRegistrationUpdatedEvent> {
      return connection.captureEvents(WorkerRegistrationUpdatedEvent::class.java)
   }

  /**
   * 
   */
   fun onWorkerVersionUpdated() : io.reactivex.Flowable<WorkerVersionUpdatedEvent> {
      return connection.captureEvents(WorkerVersionUpdatedEvent::class.java)
   }

  /**
   * 
   */
   fun onWorkerErrorReported() : io.reactivex.Flowable<WorkerErrorReportedEvent> {
      return connection.captureEvents(WorkerErrorReportedEvent::class.java)
   }
}





data class UnregisterRequest (
    /**
     * 
     */
    val scopeURL : String

)


data class UpdateRegistrationRequest (
    /**
     * 
     */
    val scopeURL : String

)


data class StartWorkerRequest (
    /**
     * 
     */
    val scopeURL : String

)


data class SkipWaitingRequest (
    /**
     * 
     */
    val scopeURL : String

)


data class StopWorkerRequest (
    /**
     * 
     */
    val versionId : String

)


data class InspectWorkerRequest (
    /**
     * 
     */
    val versionId : String

)


data class SetForceUpdateOnPageLoadRequest (
    /**
     * 
     */
    val forceUpdateOnPageLoad : Boolean

)


data class DeliverPushMessageRequest (
    /**
     * 
     */
    val origin : String,

    /**
     * 
     */
    val registrationId : String,

    /**
     * 
     */
    val data : String

)


data class DispatchSyncEventRequest (
    /**
     * 
     */
    val origin : String,

    /**
     * 
     */
    val registrationId : String,

    /**
     * 
     */
    val tag : String,

    /**
     * 
     */
    val lastChance : Boolean

)



/**
 * 
 */
data class WorkerRegistrationUpdatedEvent(
  /**
   * 
   */
  val registrations : Array<ServiceWorkerRegistration>

) : pl.wendigo.chrome.ChromeProtocolEvent(protocolDomain = "ServiceWorker", protocolEventName = "workerRegistrationUpdated")

/**
 * 
 */
data class WorkerVersionUpdatedEvent(
  /**
   * 
   */
  val versions : Array<ServiceWorkerVersion>

) : pl.wendigo.chrome.ChromeProtocolEvent(protocolDomain = "ServiceWorker", protocolEventName = "workerVersionUpdated")

/**
 * 
 */
data class WorkerErrorReportedEvent(
  /**
   * 
   */
  val errorMessage : ServiceWorkerErrorMessage

) : pl.wendigo.chrome.ChromeProtocolEvent(protocolDomain = "ServiceWorker", protocolEventName = "workerErrorReported")

