package io.rancher.service

import io.rancher.type.StateTransition
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StateTransitionApi {

  @GET('v2-beta/stateTransitions/{id}')
  Call<StateTransition> findById(@Path('id') String id)
}
