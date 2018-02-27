package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.AddRemoveServiceLinkInput
import io.rancher.type.Service
import io.rancher.type.ServiceRestart
import io.rancher.type.ServiceUpgrade
import io.rancher.type.SetServiceLinksInput
import io.rancher.type.StorageDriverService
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface StorageDriverServiceApi {
  @GET("storageDriverService")
  Call<TypeCollection<StorageDriverService>> list()

  @GET("storageDriverService")
  Call<TypeCollection<StorageDriverService>> query(@QueryMap Map<String, String> filters)

  @GET("storageDriverService/{id}")
  Call<StorageDriverService> findById(@Path("id") String id)

  @POST("storageDriverService/{id}?action=activate")
  Call<Service> activate(@Path("id") String id)

  @POST("storageDriverService/{id}?action=addservicelink")
  Call<Service> addservicelink(@Path("id") String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST("storageDriverService/{id}?action=cancelupgrade")
  Call<Service> cancelupgrade(@Path("id") String id)

  @POST("storageDriverService/{id}?action=continueupgrade")
  Call<Service> continueupgrade(@Path("id") String id)

  @POST("storageDriverService/{id}?action=deactivate")
  Call<Service> deactivate(@Path("id") String id)

  @POST("storageDriverService/{id}?action=finishupgrade")
  Call<Service> finishupgrade(@Path("id") String id)

  @POST("storageDriverService/{id}?action=remove")
  Call<Service> remove(@Path("id") String id)

  @POST("storageDriverService/{id}?action=removeservicelink")
  Call<Service> removeservicelink(@Path("id") String id, @Body AddRemoveServiceLinkInput addRemoveServiceLinkInput)

  @POST("storageDriverService/{id}?action=restart")
  Call<Service> restart(@Path("id") String id, @Body ServiceRestart serviceRestart)

  @POST("storageDriverService/{id}?action=rollback")
  Call<Service> rollback(@Path("id") String id)

  @POST("storageDriverService/{id}?action=setservicelinks")
  Call<Service> setservicelinks(@Path("id") String id, @Body SetServiceLinksInput setServiceLinksInput)

  @POST("storageDriverService/{id}?action=upgrade")
  Call<Service> upgrade(@Path("id") String id, @Body ServiceUpgrade serviceUpgrade)
}