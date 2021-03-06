package io.rancher.service

import io.rancher.type.NetworkPolicyRule
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkPolicyRuleApi {

  @POST('v2-beta/networkPolicyRules')
  Call<NetworkPolicyRule> create(@Body NetworkPolicyRule networkPolicyRule)

  @GET('v2-beta/networkPolicyRules/{id}')
  Call<NetworkPolicyRule> findById(@Path('id') String id)
}
