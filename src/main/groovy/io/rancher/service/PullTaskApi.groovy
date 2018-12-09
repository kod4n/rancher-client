package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.GenericObject
import io.rancher.type.PullTask
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface PullTaskApi {
  @GET('v2-beta/pullTasks')
  Call<TypeCollection<PullTask>> list()

  @GET('v2-beta/pullTasks')
  Call<TypeCollection<PullTask>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/pullTasks/{id}')
  Call<PullTask> findById(@Path('id') String id)

  @POST('v2-beta/pullTasks/{id}?action=remove')
  Call<GenericObject> remove(@Path('id') String id)
}
