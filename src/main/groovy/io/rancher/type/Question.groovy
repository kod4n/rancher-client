package io.rancher.type

import com.fasterxml.jackson.annotation.JsonProperty
import io.rancher.base.RancherModel
import io.rancher.base.RancherType

@RancherModel
class Question extends RancherType {
  @JsonProperty('default')
  String defaultValue
  String description
  String group
  String invalidChars
  String label
  BigInteger max
  BigInteger maxLength
  BigInteger min
  BigInteger minLength
  List<String> options
  Boolean required
  String type
  String validChars
  String variable
}
