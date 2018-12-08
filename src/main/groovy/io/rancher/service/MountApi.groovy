package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.Mount
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface MountApi {
  @GET('v2-beta/mounts')
  Call<TypeCollection<Mount>> list()

  @GET('v2-beta/mounts')
  Call<TypeCollection<Mount>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/mounts/{id}')
  Call<Mount> findById(@Path('id') String id)

  @POST('v2-beta/mounts/{id}?action=remove')
  Call<Mount> remove(@Path('id') String id)

  @POST('v2-beta/mounts/{id}?action=deactivate')
  Call<Mount> deactivate(@Path('id') String id)

}
