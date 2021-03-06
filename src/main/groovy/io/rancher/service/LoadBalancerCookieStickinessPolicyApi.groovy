package io.rancher.service

import io.rancher.type.LoadBalancerCookieStickinessPolicy
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LoadBalancerCookieStickinessPolicyApi {

  @GET('v2-beta/loadBalancerCookieStickinessPolicys/{id}')
  Call<LoadBalancerCookieStickinessPolicy> findById(@Path('id') String id)
}
