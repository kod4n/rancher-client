package io.rancher.service

import io.rancher.type.NetworkPolicyRuleMember
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface NetworkPolicyRuleMemberApi {

  @POST('v2-beta/networkPolicyRuleMembers')
  Call<NetworkPolicyRuleMember> create(@Body NetworkPolicyRuleMember networkPolicyRuleMember)

  @GET('v2-beta/networkPolicyRuleMembers/{id}')
  Call<NetworkPolicyRuleMember> findById(@Path('id') String id)
}
