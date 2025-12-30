data class Doctor(val name: String, val consultationTime: Int)

class ClinicQueueSystem(private val doctors: List<Doctor>) {
    private val queue: MutableList<String> = mutableListOf()

    fun joinQueue(patientName: String) {
        queue.add(patientName)
    }

    fun getQueue(): List<String> {
        return queue.toList()
    }

    fun estimateWaitingTime(positionInQueue: Int): Double {
        val patientsAhead = positionInQueue - 1
        // Estimate waiting time based on average consultation times
        return String.format("%.1f",patientsAhead/doctors.size * averageConsultationTime()).toDouble()
    }

    private fun averageConsultationTime(): Double {
        // Calculate the average consultation time for all doctors
        return doctors.map { it.consultationTime }.average()
    }
}

fun main() {
    // Example usage with a list of doctors and 3 patients in the queue
    val doctors = listOf(
        Doctor(name = "Dr. A", consultationTime = 3),
        Doctor(name = "Dr. B", consultationTime = 4),
        Doctor(name="Dr. C", consultationTime= 3)
    )

    val patients = listOf("Lucas","Pet","Luna")


    val clinicSystem = ClinicQueueSystem(doctors = doctors)

    // add patients from the list in the queue
    patients.forEach{
        clinicSystem.joinQueue(it)
    }

    //add more patients (that would be user input in screen)
    clinicSystem.joinQueue("John")
    clinicSystem.joinQueue("Molly")

    // Estimate waiting time for each patient and print
    println("Estimated waiting time for \n")
    clinicSystem.getQueue().forEachIndexed { index, patientName ->
        val positionInQueue = index + 1
        val waitingTime = clinicSystem.estimateWaitingTime(positionInQueue)
        println("$patientName: $waitingTime mins")
    }
}

// Output will be ->
// Estimated waiting time for
//
// Lucas: 0.0 mins
// Pet: 0.0 mins
// Luna: 0.0 mins
// John: 3.3 mins
// Molly: 3.3 mins