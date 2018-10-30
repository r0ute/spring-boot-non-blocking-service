package com.example.nonblocking

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BlockingSimulation extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8080")

  val scn = scenario("Blocking Simulation")
    .exec(http("blocking-request")
      .get("/blocking")
      .check(status.is(200))
    )

  setUp(
    scn.inject(rampUsersPerSec(50).to(200).during(120))
  ).protocols(httpConf)
}