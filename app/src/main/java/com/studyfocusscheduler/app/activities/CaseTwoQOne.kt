fun calculateEstimatedWaitingTime(
    numberOfPatientsAhead: Int,
    averageConsultationTimeDoctorA: Int,
    averageConsultationTimeDoctorB: Int,
    emergencyAdditionalTime: Int
): Double {
    val combinedCapacity = 2 // Assuming both doctors start seeing patients at the same time
    val averageConsultationTime =
        intArrayOf(averageConsultationTimeDoctorA, averageConsultationTimeDoctorB).average()

    return (numberOfPatientsAhead / combinedCapacity) * averageConsultationTime + emergencyAdditionalTime
}

fun main() {
    // Example values
    val numberOfPatientsAhead = 10
    val averageConsultationTimeDoctorA = 3 // minutes
    val averageConsultationTimeDoctorB = 4 // minutes
    val emergencyAdditionalTime = 0 // Assuming no emergencies for this example

    val estimatedWaitingTime = calculateEstimatedWaitingTime(
        numberOfPatientsAhead,
        averageConsultationTimeDoctorA,
        averageConsultationTimeDoctorB,
        emergencyAdditionalTime
    )

    println("John's estimated waiting time: $estimatedWaitingTime minutes")
}

// Output will be ->
// John's estimated waiting time: 17.5 minutes
