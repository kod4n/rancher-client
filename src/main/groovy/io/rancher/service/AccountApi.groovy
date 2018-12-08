package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Account
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface AccountApi {
  @GET('v2-beta/accounts')
  Call<TypeCollection<Account>> list()

  @GET('v2-beta/accounts')
  Call<TypeCollection<Account>> query(@QueryMap Map<String, String> filters)

  @POST('v2-beta/accounts')
  Call<Account> create(@Body Account account)

  @GET('v2-beta/accounts/{id}')
  Call<Account> findById(@Path('id') String id)

  @PUT('v2-beta/accounts/{id}')
  Call<Account> update(@Path('id') String id, @Body Account account)

  @DELETE('v2-beta/accounts/{id}')
  Call<Account> delete(@Path('id') String id)

  @POST('v2-beta/accounts/{id}?action=upgrade')
  Call<Account> upgrade(@Path('id') String id)

  @POST('v2-beta/accounts/{id}?action=activate')
  Call<Account> activate(@Path('id') String id)

  @POST('v2-beta/accounts/{id}?action=purge')
  Call<Account> purge(@Path('id') String id)

  @POST('v2-beta/accounts/{id}?action=remove')
  Call<Account> remove(@Path('id') String id)

  @POST('v2-beta/accounts/{id}?action=deactivate')
  Call<Account> deactivate(@Path('id') String id)

}
