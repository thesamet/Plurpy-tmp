package org.tomasmo.plurpy

import v1.account.AccountsService.ZioAccountsService.ZAccountsService
import v1.account.AccountsService._

import io.grpc.Status
import zio.Console.printLine
import zio.ZIO

object AccountsServiceImpl extends ZAccountsService[Any, Any] {
  override def signup(request: SignupRequest): ZIO[Any, Status, SignupResponse] = {
    printLine(s"sdsdf request: $request").orDie zipRight
      ZIO.succeed(SignupResponse(authToken = s"Very secret token for, ${request.getAccount.name}"))
  }

  override def login(request: LoginRequest): ZIO[Any, Status, LoginResponse] = ???

  override def logout(request: LogoutRequest): ZIO[Any, Status, LogoutResponse] = ???
}
