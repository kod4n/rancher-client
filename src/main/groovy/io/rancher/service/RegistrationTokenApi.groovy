package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.RegistrationToken
import io.rancher.type.Credential
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface RegistrationTokenApi {
  @GET('v2-beta/registrationTokens')
  Call<TypeCollection<RegistrationToken>> list()

  @GET('v2-beta/registrationTokens')
  Call<TypeCollection<RegistrationToken>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/registrationTokens/{id}')
  Call<RegistrationToken> findById(@Path('id') String id)

  @POST('v2-beta/registrationTokens/{id}?action=activate')
  Call<Credential> activate(@Path('id') String id)

  @POST('v2-beta/registrationTokens/{id}?action=purge')
  Call<Credential> purge(@Path('id') String id)

  @POST('v2-beta/registrationTokens/{id}?action=remove')
  Call<Credential> remove(@Path('id') String id)

  @POST('v2-beta/registrationTokens/{id}?action=deactivate')
  Call<Credential> deactivate(@Path('id') String id)

}
