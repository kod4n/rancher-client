package io.rancher.type

import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class ExternalServiceEvent extends RancherType {
  String accountId
  String created
  Map<String, Object> data
  String eventType
  String externalId
  String kind
  String reportedAccountId
  String state
  String transitioning
  String transitioningMessage
  BigInteger transitioningProgress
  String uuid
  Map<String, Object> service
  Map<String, Object> environment
}
