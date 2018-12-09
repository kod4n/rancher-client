package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.UserPreference
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface UserPreferenceApi {
  @GET('v2-beta/userPreferences')
  Call<TypeCollection<UserPreference>> list()

  @GET('v2-beta/userPreferences')
  Call<TypeCollection<UserPreference>> query(@QueryMap Map<String, String> filters)

  @POST('v2-beta/userPreferences')
  Call<UserPreference> create(@Body UserPreference userPreference)

  @GET('v2-beta/userPreferences/{id}')
  Call<UserPreference> findById(@Path('id') String id)

  @PUT('v2-beta/userPreferences/{id}')
  Call<UserPreference> update(@Path('id') String id, @Body UserPreference userPreference)

  @DELETE('v2-beta/userPreferences/{id}')
  Call<UserPreference> delete(@Path('id') String id)

  @POST('v2-beta/userPreferences/{id}?action=activate')
  Call<UserPreference> activate(@Path('id') String id)

  @POST('v2-beta/userPreferences/{id}?action=purge')
  Call<UserPreference> purge(@Path('id') String id)

  @POST('v2-beta/userPreferences/{id}?action=remove')
  Call<UserPreference> remove(@Path('id') String id)

  @POST('v2-beta/userPreferences/{id}?action=deactivate')
  Call<UserPreference> deactivate(@Path('id') String id)
}
