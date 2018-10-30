package com.example.nonblocking

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class NonBlockingSimulation extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080")

  val scn = scenario("Non-blocking Simulation")
    .exec(http("non-blocking-request")
      .get("/non-blocking")
      .check(status.is(200))
    )

  setUp(
    scn.inject(rampUsersPerSec(50).to(200).during(120))
  ).protocols(httpConf)
}