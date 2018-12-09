package io.rancher.service

import io.rancher.type.TargetPortRule
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TargetPortRuleApi {

  @GET('v2-beta/targetPortRules/{id}')
  Call<TargetPortRule> findById(@Path('id') String id)
}
