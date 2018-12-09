package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.AccountLink
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface AccountLinkApi {
  @GET('v2-beta/accountLinks')
  Call<TypeCollection<AccountLink>> list()

  @GET('v2-beta/accountLinks')
  Call<TypeCollection<AccountLink>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/accountLinks/{id}')
  Call<AccountLink> findById(@Path('id') String id)

  @POST('v2-beta/accountLinks/{id}?action=activate')
  Call<AccountLink> activate(@Path('id') String id)

  @POST('v2-beta/accountLinks/{id}?action=purge')
  Call<AccountLink> purge(@Path('id') String id)

  @POST('v2-beta/accountLinks/{id}?action=remove')
  Call<AccountLink> remove(@Path('id') String id)

  @POST('v2-beta/accountLinks/{id}?action=deactivate')
  Call<AccountLink> deactivate(@Path('id') String id)
}
