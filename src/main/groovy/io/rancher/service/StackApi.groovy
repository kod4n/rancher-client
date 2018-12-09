package io.rancher.service

import io.rancher.base.TypeCollection
import io.rancher.type.AddOutputsInput
import io.rancher.type.ComposeConfig
import io.rancher.type.ComposeConfigInput
import io.rancher.type.Stack
import io.rancher.type.StackUpgrade
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface StackApi {
  @GET('v2-beta/stacks')
  Call<TypeCollection<Stack>> list()

  @GET('v2-beta/stacks')
  Call<TypeCollection<Stack>> query(@QueryMap Map<String, String> filters)

  @GET('v2-beta/stacks/{id}')
  Call<Stack> findById(@Path('id') String id)

  @POST('v2-beta/stacks/{id}?action=rollback')
  Call<Stack> rollback(@Path('id') String id)

  @POST('v2-beta/stacks/{id}?action=deactivateservices')
  Call<Stack> deactivateservices(@Path('id') String id)

  @POST('v2-beta/stacks/{id}?action=activateservices')
  Call<Stack> activateservices(@Path('id') String id)

  @POST('v2-beta/stacks/{id}?action=upgrade')
  Call<Stack> upgrade(@Path('id') String id, @Body StackUpgrade stackUpgrade)

  @POST('v2-beta/stacks/{id}?action=addoutputs')
  Call<Stack> addoutputs(@Path('id') String id, @Body AddOutputsInput addOutputsInput)

  @POST('v2-beta/stacks/{id}?action=exportconfig')
  Call<ComposeConfig> exportconfig(@Path('id') String id, @Body ComposeConfigInput composeConfigInput)

  @POST('v2-beta/stacks/{id}?action=error')
  Call<Stack> error(@Path('id') String id)

  @POST('v2-beta/stacks/{id}?action=cancelupgrade')
  Call<Stack> cancelupgrade(@Path('id') String id)

  @POST('v2-beta/stacks/{id}?action=remove')
  Call<Stack> remove(@Path('id') String id)

  @POST('v2-beta/stacks/{id}?action=finishupgrade')
  Call<Stack> finishupgrade(@Path('id') String id)
}
