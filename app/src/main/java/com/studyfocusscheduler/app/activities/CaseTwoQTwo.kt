
fun main() {
    // Initialize variables
    val averageConsultationTimeA = 3 // minutes
    val averageConsultationTimeB = 4 // minutes
    val currentPatientTimeB = 2 // minutes
    val patientsAheadOfJohn = 10
    val emergencyAdditionalTime = 0 // Assuming no emergencies for this example

    // Calculate the average consultation time considering both doctors
    val averageConsultationTime = intArrayOf(averageConsultationTimeA , averageConsultationTimeB).average()

    // Calculate remaining time for the current patient with Doctor B
    val remainingTimeB = maxOf(0, averageConsultationTimeB - currentPatientTimeB)

    // Calculate time for patients ahead of John (subtracting 1 for the patient currently with Doctor B)
    val timeForPatientsAhead = (patientsAheadOfJohn - 1) * averageConsultationTime

    // Calculate John's estimated waiting time
    val johnWaitingTime = timeForPatientsAhead + remainingTimeB + emergencyAdditionalTime

    // Display the result
    println("John's estimated waiting time: $johnWaitingTime minutes")


}

// Output will be ->
// John's estimated waiting time: 33.5 minutes
