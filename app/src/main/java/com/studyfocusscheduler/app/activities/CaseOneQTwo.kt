fun calculateWaitingTime(patientsAhead: Int, averageConsultationTime: Int, peterConsultationTime: Int,
    emergencyAdditionalTime: Int): Int {
    val waitingTime = (patientsAhead * averageConsultationTime) - peterConsultationTime + emergencyAdditionalTime
    return if (waitingTime < 0) 0 else waitingTime
}

fun main() {
    // Input values
    val patientsAhead = 5
    val averageConsultationTime = 3
    val peterConsultationTimeScenarioA = 2
    val peterConsultationTimeScenarioB = 5
    val emergencyAdditionalTime = 0 // Assuming no emergencies for this example

    // Calculate waiting time for Scenario (a)
    val waitingTimeScenarioA = calculateWaitingTime(patientsAhead, averageConsultationTime, peterConsultationTimeScenarioA,emergencyAdditionalTime)
    println("Estimated waiting time for Scenario (a): $waitingTimeScenarioA minutes")

    // Calculate waiting time for Scenario (b)
    val waitingTimeScenarioB = calculateWaitingTime(patientsAhead, averageConsultationTime, peterConsultationTimeScenarioB,emergencyAdditionalTime)
    println("Estimated waiting time for Scenario (b): $waitingTimeScenarioB minutes")
}

// Output will be ->
//Estimated waiting time for Scenario (a): 13 minutes
//Estimated waiting time for Scenario (b): 10 minutes