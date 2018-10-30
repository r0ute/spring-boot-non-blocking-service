package com.example.nonblocking

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PerfSimulation extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080")

  val blockingScn = scenario("Blocking Simulation")
    .exec(http("blocking-request")
      .get("/blocking")
      .check(status.is(200))
    )

  val nonBlockingScn = scenario("Non-blocking Simulation")
    .exec(http("non-blocking-request")
      .get("/non-blocking")
      .check(status.is(200))
    )

  val profile = rampUsersPerSec(50).to(200).during(120)

  setUp(
    blockingScn.inject(profile),
    nonBlockingScn.inject(profile)
  ).protocols(httpConf)
}