.PHONY: docker-build
docker-build:
	docker build -t claudioed/http-sampler:latest .

.PHONY: docker-push
docker-push:
	docker push claudioed/http-sampler:latest

install-kind-local:
	helm install http-sampler http-sampler -n analytics
