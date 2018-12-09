package io.rancher.service

import io.rancher.type.NetworkPolicyRuleBetween
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkPolicyRuleBetweenApi {

  @POST('v2-beta/networkPolicyRuleBetweens')
  Call<NetworkPolicyRuleBetween> create(@Body NetworkPolicyRuleBetween networkPolicyRuleBetween)

  @GET('v2-beta/networkPolicyRuleBetweens/{id}')
  Call<NetworkPolicyRuleBetween> findById(@Path('id') String id)
}
