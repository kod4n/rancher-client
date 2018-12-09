package io.rancher.service

import io.rancher.type.PortRule
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PortRuleApi {

  @GET('v2-beta/portRules/{id}')
  Call<PortRule> findById(@Path('id') String id)
}
