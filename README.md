# empty-post-reproducer

Trying to reproduce a bug I'm seeing with Spring Cloud Gateway 2.0.0.M5

However, I can't get this to work.

When I run the tests, I get a `java.lang.IllegalStateException: unexpected message type: UnpooledHeapByteBuf`

<details>
  <summary>Stacktrace</summary>

```
io.netty.handler.codec.EncoderException: java.lang.IllegalStateException: unexpected message type: UnpooledHeapByteBuf
	at io.netty.handler.codec.MessageToMessageEncoder.write(MessageToMessageEncoder.java:106) ~[netty-codec-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.CombinedChannelDuplexHandler.write(CombinedChannelDuplexHandler.java:348) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:738) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite(AbstractChannelHandlerContext.java:730) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:816) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:723) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at reactor.ipc.netty.channel.ChannelOperationsHandler.doWrite(ChannelOperationsHandler.java:283) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at reactor.ipc.netty.channel.ChannelOperationsHandler$PublisherSender.onNext(ChannelOperationsHandler.java:599) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onNext(FluxOnAssembly.java:450) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onNext(FluxMapFuseable.java:115) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onNext(FluxOnAssembly.java:450) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxMap$MapSubscriber.onNext(FluxMap.java:108) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher.readAndPublish(AbstractListenerReadPublisher.java:155) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher.access$1000(AbstractListenerReadPublisher.java:47) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher$State$4.onDataAvailable(AbstractListenerReadPublisher.java:317) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher.onDataAvailable(AbstractListenerReadPublisher.java:85) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at org.springframework.http.server.reactive.ServletServerHttpRequest$RequestBodyPublisher.checkOnDataAvailable(ServletServerHttpRequest.java:256) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher.changeToDemandState(AbstractListenerReadPublisher.java:177) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher.access$900(AbstractListenerReadPublisher.java:47) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher$State$2.request(AbstractListenerReadPublisher.java:278) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher$ReadSubscription.request(AbstractListenerReadPublisher.java:197) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at reactor.core.publisher.FluxMap$MapSubscriber.request(FluxMap.java:149) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.request(FluxOnAssembly.java:532) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.request(FluxMapFuseable.java:156) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.request(FluxOnAssembly.java:532) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.ipc.netty.channel.ChannelOperationsHandler$PublisherSender.onSubscribe(ChannelOperationsHandler.java:628) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onSubscribe(FluxOnAssembly.java:516) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onSubscribe(FluxMapFuseable.java:90) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onSubscribe(FluxOnAssembly.java:516) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxMap$MapSubscriber.onSubscribe(FluxMap.java:86) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher$State$1.subscribe(AbstractListenerReadPublisher.java:238) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at org.springframework.http.server.reactive.AbstractListenerReadPublisher.subscribe(AbstractListenerReadPublisher.java:72) ~[spring-web-5.0.2.RELEASE.jar:5.0.2.RELEASE]
	at reactor.core.publisher.FluxSource.subscribe(FluxSource.java:52) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxMap.subscribe(FluxMap.java:62) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly.subscribe(FluxOnAssembly.java:252) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxMapFuseable.subscribe(FluxMapFuseable.java:63) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly.subscribe(FluxOnAssembly.java:252) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.Flux.subscribe(Flux.java:6571) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.ipc.netty.channel.ChannelOperationsHandler.drain(ChannelOperationsHandler.java:459) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at reactor.ipc.netty.channel.ChannelOperationsHandler.flush(ChannelOperationsHandler.java:183) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at io.netty.channel.AbstractChannelHandlerContext.invokeFlush0(AbstractChannelHandlerContext.java:776) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWriteAndFlush(AbstractChannelHandlerContext.java:802) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:814) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.writeAndFlush(AbstractChannelHandlerContext.java:794) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.writeAndFlush(AbstractChannelHandlerContext.java:831) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.DefaultChannelPipeline.writeAndFlush(DefaultChannelPipeline.java:1041) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannel.writeAndFlush(AbstractChannel.java:300) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at reactor.ipc.netty.NettyOutbound.lambda$sendObject$6(NettyOutbound.java:298) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at reactor.ipc.netty.FutureMono$DeferredFutureMono.subscribe(FutureMono.java:106) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.drain(MonoIgnoreThen.java:148) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.ignoreDone(MonoIgnoreThen.java:185) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreInner.onComplete(MonoIgnoreThen.java:234) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.ipc.netty.FutureMono$FutureSubscription.operationComplete(FutureMono.java:162) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at io.netty.util.concurrent.DefaultPromise.notifyListener0(DefaultPromise.java:507) ~[netty-common-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.util.concurrent.DefaultPromise.notifyListenersNow(DefaultPromise.java:481) ~[netty-common-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.util.concurrent.DefaultPromise.notifyListeners(DefaultPromise.java:420) ~[netty-common-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.util.concurrent.DefaultPromise.trySuccess(DefaultPromise.java:104) ~[netty-common-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.util.internal.PromiseNotificationUtil.trySuccess(PromiseNotificationUtil.java:48) ~[netty-common-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.ChannelOutboundBuffer.safeSuccess(ChannelOutboundBuffer.java:673) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.ChannelOutboundBuffer.remove(ChannelOutboundBuffer.java:257) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.ChannelOutboundBuffer.removeBytes(ChannelOutboundBuffer.java:337) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.socket.nio.NioSocketChannel.doWrite(NioSocketChannel.java:419) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannel$AbstractUnsafe.flush0(AbstractChannel.java:934) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.nio.AbstractNioChannel$AbstractNioUnsafe.flush0(AbstractNioChannel.java:362) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannel$AbstractUnsafe.flush(AbstractChannel.java:901) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.DefaultChannelPipeline$HeadContext.flush(DefaultChannelPipeline.java:1321) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeFlush0(AbstractChannelHandlerContext.java:776) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeFlush(AbstractChannelHandlerContext.java:768) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.flush(AbstractChannelHandlerContext.java:749) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.flush(CombinedChannelDuplexHandler.java:533) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.ChannelOutboundHandlerAdapter.flush(ChannelOutboundHandlerAdapter.java:115) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.CombinedChannelDuplexHandler.flush(CombinedChannelDuplexHandler.java:358) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeFlush0(AbstractChannelHandlerContext.java:776) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeFlush(AbstractChannelHandlerContext.java:768) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.flush(AbstractChannelHandlerContext.java:749) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at reactor.ipc.netty.channel.ChannelOperationsHandler.lambda$scheduleFlush$1(ChannelOperationsHandler.java:331) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:163) ~[netty-common-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:403) ~[netty-common-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:463) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:858) ~[netty-common-4.1.17.Final.jar:4.1.17.Final]
	at java.lang.Thread.run(Thread.java:748) ~[na:1.8.0_151]
	Suppressed: reactor.core.publisher.FluxOnAssembly$OnAssemblyException: 
Assembly trace from producer [reactor.core.publisher.MonoIgnoreThen] :
	reactor.core.publisher.Mono.then(Mono.java:3230)
	reactor.core.publisher.Mono.thenEmpty(Mono.java:3246)
	reactor.ipc.netty.ReactorNetty$OutboundThen.<init>(ReactorNetty.java:253)
	reactor.ipc.netty.NettyOutbound.then(NettyOutbound.java:378)
	reactor.ipc.netty.NettyOutbound.sendObject(NettyOutbound.java:297)
	reactor.ipc.netty.NettyOutbound.send(NettyOutbound.java:156)
	org.springframework.cloud.gateway.filter.NettyRoutingFilter.lambda$filter$2(NettyRoutingFilter.java:98)
	reactor.ipc.netty.http.client.MonoHttpClientResponse$HttpClientHandler.apply(MonoHttpClientResponse.java:119)
	reactor.ipc.netty.http.client.MonoHttpClientResponse$HttpClientHandler.apply(MonoHttpClientResponse.java:82)
	reactor.ipc.netty.channel.ChannelOperations.applyHandler(ChannelOperations.java:382)
	reactor.ipc.netty.http.client.HttpClientOperations.onHandlerStart(HttpClientOperations.java:479)
	io.netty.util.concurrent.AbstractEventExecutor.safeExecute(AbstractEventExecutor.java:163)
	io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:403)
	io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:463)
	io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:858)
Error has been observed by the following operator(s):
	|_	Mono.thenEmpty(ReactorNetty.java:253)
	|_	Mono.fromDirect(ChannelOperations.java:382)
	|_	Mono.create(TcpClient.java:174)
	|_	Mono.defer(MonoHttpClientResponse.java:73)
	|_	Mono.retry(MonoHttpClientResponse.java:77)
	|_	Mono.cast(MonoHttpClientResponse.java:78)
	|_	Mono.doOnNext(NettyRoutingFilter.java:101)
	|_	Mono.then(NettyRoutingFilter.java:113)
	|_	Mono.then(NettyWriteResponseFilter.java:52)
	|_	Mono.then(SimpleHandlerAdapter.java:63)
	|_	Mono.flatMap(DispatcherHandler.java:160)
	|_	Mono.flatMap(DispatcherHandler.java:161)

Caused by: java.lang.IllegalStateException: unexpected message type: UnpooledHeapByteBuf
	at io.netty.handler.codec.http.HttpObjectEncoder.encode(HttpObjectEncoder.java:123) ~[netty-codec-http-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.handler.codec.http.HttpClientCodec$Encoder.encode(HttpClientCodec.java:167) ~[netty-codec-http-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.handler.codec.MessageToMessageEncoder.write(MessageToMessageEncoder.java:88) ~[netty-codec-4.1.17.Final.jar:4.1.17.Final]
	... 80 common frames omitted

```

</details>



When I run the app and execute the request manually (via httpie), I get a `java.lang.ClassCastException: org.springframework.core.io.buffer.DefaultDataBufferFactory cannot be cast to org.springframework.core.io.buffer.NettyDataBufferFactory`:

<details>
  <summary>Stacktrace</summary>

```
java.lang.ClassCastException: org.springframework.core.io.buffer.DefaultDataBufferFactory cannot be cast to org.springframework.core.io.buffer.NettyDataBufferFactory
	at org.springframework.cloud.gateway.filter.NettyWriteResponseFilter.lambda$filter$0(NettyWriteResponseFilter.java:61) ~[spring-cloud-gateway-core-2.0.0.M5.jar:2.0.0.M5]
	at reactor.core.publisher.MonoDefer.subscribe(MonoDefer.java:44) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoOnAssembly.subscribe(MonoOnAssembly.java:76) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.drain(MonoIgnoreThen.java:148) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.ignoreDone(MonoIgnoreThen.java:185) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreInner.onComplete(MonoIgnoreThen.java:234) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onComplete(FluxOnAssembly.java:460) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.drain(MonoIgnoreThen.java:139) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.ignoreDone(MonoIgnoreThen.java:185) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoIgnoreThen$ThenIgnoreInner.onComplete(MonoIgnoreThen.java:234) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onComplete(FluxOnAssembly.java:460) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxPeek$PeekSubscriber.onComplete(FluxPeek.java:245) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onComplete(FluxOnAssembly.java:460) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onComplete(FluxMapFuseable.java:138) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onComplete(FluxOnAssembly.java:460) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxRetryPredicate$RetryPredicateSubscriber.onComplete(FluxRetryPredicate.java:107) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onComplete(FluxOnAssembly.java:460) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.FluxOnAssembly$OnAssemblySubscriber.onComplete(FluxOnAssembly.java:460) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.core.publisher.MonoCreate$DefaultMonoSink.success(MonoCreate.java:140) ~[reactor-core-3.1.2.RELEASE.jar:3.1.2.RELEASE]
	at reactor.ipc.netty.channel.PooledClientContextHandler.fireContextActive(PooledClientContextHandler.java:84) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at reactor.ipc.netty.http.client.HttpClientOperations.onInboundNext(HttpClientOperations.java:551) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at reactor.ipc.netty.channel.ChannelOperationsHandler.channelRead(ChannelOperationsHandler.java:132) ~[reactor-netty-0.7.2.RELEASE.jar:0.7.2.RELEASE]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.fireChannelRead(CombinedChannelDuplexHandler.java:438) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:310) ~[netty-codec-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:284) ~[netty-codec-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.CombinedChannelDuplexHandler.channelRead(CombinedChannelDuplexHandler.java:253) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:340) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1359) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:362) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:348) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:935) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:138) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:645) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:580) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:497) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:459) ~[netty-transport-4.1.17.Final.jar:4.1.17.Final]
	at io.netty.util.concurrent.SingleThreadEventExecutor$5.run(SingleThreadEventExecutor.java:858) ~[netty-common-4.1.17.Final.jar:4.1.17.Final]
	at java.lang.Thread.run(Thread.java:748) ~[na:1.8.0_151]
	Suppressed: reactor.core.publisher.FluxOnAssembly$OnAssemblyException: 
Assembly trace from producer [reactor.core.publisher.MonoDefer] :
	reactor.core.publisher.Mono.defer(Mono.java:189)
	org.springframework.cloud.gateway.filter.NettyWriteResponseFilter.filter(NettyWriteResponseFilter.java:52)
	org.springframework.cloud.gateway.handler.FilteringWebHandler$GatewayFilterAdapter.filter(FilteringWebHandler.java:121)
	org.springframework.cloud.gateway.filter.OrderedGatewayFilter.filter(OrderedGatewayFilter.java:40)
	org.springframework.cloud.gateway.handler.FilteringWebHandler$DefaultGatewayFilterChain.filter(FilteringWebHandler.java:103)
	org.springframework.cloud.gateway.handler.FilteringWebHandler.handle(FilteringWebHandler.java:87)
	org.springframework.web.reactive.result.SimpleHandlerAdapter.handle(SimpleHandlerAdapter.java:62)
	org.springframework.web.reactive.DispatcherHandler.invokeHandler(DispatcherHandler.java:168)
	org.springframework.web.reactive.DispatcherHandler.lambda$handle$1(DispatcherHandler.java:160)
	reactor.core.publisher.MonoFlatMap$FlatMapMain.onNext(MonoFlatMap.java:118)
	reactor.core.publisher.FluxSwitchIfEmpty$SwitchIfEmptySubscriber.onNext(FluxSwitchIfEmpty.java:67)
	reactor.core.publisher.MonoNext$NextSubscriber.onNext(MonoNext.java:76)
	reactor.core.publisher.FluxConcatMap$ConcatMapImmediate.innerNext(FluxConcatMap.java:271)
	reactor.core.publisher.FluxConcatMap$ConcatMapInner.onNext(FluxConcatMap.java:803)
	reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onNext(FluxMapFuseable.java:115)
	reactor.core.publisher.FluxSwitchIfEmpty$SwitchIfEmptySubscriber.onNext(FluxSwitchIfEmpty.java:67)
	reactor.core.publisher.Operators$MonoSubscriber.complete(Operators.java:1092)
	reactor.core.publisher.MonoFlatMap$FlatMapMain.onNext(MonoFlatMap.java:144)
	reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onNext(FluxMapFuseable.java:115)
	reactor.core.publisher.MonoNext$NextSubscriber.onNext(MonoNext.java:76)
	reactor.core.publisher.FluxFilterFuseable$FilterFuseableSubscriber.tryOnNext(FluxFilterFuseable.java:129)
	reactor.core.publisher.FluxIterable$IterableSubscriptionConditional.fastPath(FluxIterable.java:574)
	reactor.core.publisher.FluxIterable$IterableSubscriptionConditional.request(FluxIterable.java:459)
	reactor.core.publisher.FluxFilterFuseable$FilterFuseableSubscriber.request(FluxFilterFuseable.java:170)
	reactor.core.publisher.MonoNext$NextSubscriber.request(MonoNext.java:102)
	reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.request(FluxMapFuseable.java:156)
	reactor.core.publisher.MonoFlatMap$FlatMapMain.onSubscribe(MonoFlatMap.java:103)
	reactor.core.publisher.FluxMapFuseable$MapFuseableSubscriber.onSubscribe(FluxMapFuseable.java:90)
	reactor.core.publisher.MonoNext$NextSubscriber.onSubscribe(MonoNext.java:64)
	reactor.core.publisher.FluxFilterFuseable$FilterFuseableSubscriber.onSubscribe(FluxFilterFuseable.java:79)
	reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:124)
	reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:61)
	reactor.core.publisher.FluxFilterFuseable.subscribe(FluxFilterFuseable.java:51)
	reactor.core.publisher.MonoNext.subscribe(MonoNext.java:40)
	reactor.core.publisher.MonoMapFuseable.subscribe(MonoMapFuseable.java:59)
	reactor.core.publisher.MonoFlatMap.subscribe(MonoFlatMap.java:60)
	reactor.core.publisher.MonoSwitchIfEmpty.subscribe(MonoSwitchIfEmpty.java:44)
	reactor.core.publisher.MonoMapFuseable.subscribe(MonoMapFuseable.java:59)
	reactor.core.publisher.Mono.subscribe(Mono.java:3008)
	reactor.core.publisher.FluxConcatMap$ConcatMapImmediate.drain(FluxConcatMap.java:418)
	reactor.core.publisher.FluxConcatMap$ConcatMapImmediate.onSubscribe(FluxConcatMap.java:210)
	reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:128)
	reactor.core.publisher.FluxIterable.subscribe(FluxIterable.java:61)
	reactor.core.publisher.FluxConcatMap.subscribe(FluxConcatMap.java:121)
	reactor.core.publisher.MonoNext.subscribe(MonoNext.java:40)
	reactor.core.publisher.MonoSwitchIfEmpty.subscribe(MonoSwitchIfEmpty.java:44)
	reactor.core.publisher.MonoFlatMap.subscribe(MonoFlatMap.java:60)
	reactor.core.publisher.MonoFlatMap.subscribe(MonoFlatMap.java:60)
	reactor.core.publisher.MonoOnErrorResume.subscribe(MonoOnErrorResume.java:44)
	reactor.core.publisher.MonoOnErrorResume.subscribe(MonoOnErrorResume.java:44)
	reactor.core.publisher.MonoOnErrorResume.subscribe(MonoOnErrorResume.java:44)
	reactor.core.publisher.Mono.subscribe(Mono.java:3008)
	reactor.core.publisher.MonoIgnoreThen$ThenIgnoreMain.drain(MonoIgnoreThen.java:167)
	reactor.core.publisher.MonoIgnoreThen.subscribe(MonoIgnoreThen.java:56)
	reactor.core.publisher.Mono.subscribe(Mono.java:3008)
	org.springframework.http.server.reactive.ServletHttpHandlerAdapter.service(ServletHttpHandlerAdapter.java:169)
	org.eclipse.jetty.servlet.ServletHolder.handle(ServletHolder.java:841)
	org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:535)
	org.eclipse.jetty.server.handler.ScopedHandler.nextHandle(ScopedHandler.java:188)
	org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1253)
	org.eclipse.jetty.server.handler.ScopedHandler.nextScope(ScopedHandler.java:168)
	org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:473)
	org.eclipse.jetty.server.handler.ScopedHandler.nextScope(ScopedHandler.java:166)
	org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:1155)
	org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:141)
	org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:132)
	org.eclipse.jetty.server.Server.handle(Server.java:561)
	org.eclipse.jetty.server.HttpChannel.handle(HttpChannel.java:334)
	org.eclipse.jetty.server.HttpConnection.onFillable(HttpConnection.java:251)
	org.eclipse.jetty.io.AbstractConnection$ReadCallback.succeeded(AbstractConnection.java:279)
	org.eclipse.jetty.io.FillInterest.fillable(FillInterest.java:104)
	org.eclipse.jetty.io.ChannelEndPoint$2.run(ChannelEndPoint.java:124)
	org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:679)
	org.eclipse.jetty.util.thread.QueuedThreadPool$2.run(QueuedThreadPool.java:597)
Error has been observed by the following operator(s):
	|_	Mono.defer(NettyWriteResponseFilter.java:52)
	|_	Mono.then(NettyWriteResponseFilter.java:52)
	|_	Mono.then(SimpleHandlerAdapter.java:63)
	|_	Mono.flatMap(DispatcherHandler.java:160)
	|_	Mono.flatMap(DispatcherHandler.java:161)
```

</details>
