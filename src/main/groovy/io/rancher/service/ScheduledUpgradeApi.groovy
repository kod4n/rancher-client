package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.ScheduledUpgrade
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ScheduledUpgradeApi {
  @GET('v2-beta/scheduledUpgrades')
  Call<TypeCollection<ScheduledUpgrade>> list()

  @GET('v2-beta/scheduledUpgrades')
  Call<TypeCollection<ScheduledUpgrade>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/scheduledUpgrades/{id}')
  Call<ScheduledUpgrade> findById(@Path('id') String id)

  @POST('v2-beta/scheduledUpgrades/{id}?action=start')
  Call<ScheduledUpgrade> start(@Path('id') String id)

  @POST('v2-beta/scheduledUpgrades/{id}?action=remove')
  Call<ScheduledUpgrade> remove(@Path('id') String id)

}
