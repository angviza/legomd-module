#!/usr/bin/env bash


# $1: namespace
# $2: deployment name
function is_deployment_created()
{
    echo "start is deployment created"

    kubectl get --namespace=$1 deploy/$2

    if [ $? -eq 0 ]; then
        echo "finish is deployment created with return 1"
        return 1
    else
        echo "finish is deployment created with return 0"
        return 0
    fi
}

# $1: yaml path
function create_deployment()
{

    echo "start create deployment"

    kubectl create -f $1

    if [ $? -eq 0 ]; then
        echo "finish create deployment with return 1"
        return 1
    else
        echo "finish create deployment with return 0"
        return 0
    fi
}

# $1: namespace
# $2: deployment name
function delete_deployment()
{

    echo "start delete deployment"

    kubectl --namespace=$1 delete deploy/$2

    if [ $? -eq 0 ]; then
        echo "finish delete deployment with return 1"
        return 1
    else
        echo "finish delete deployment with return 0"
        return 0
    fi
}

# $1: yaml path
# $2: namespace
# $3: deployment name
function update_deployment()
{
    delete_deployment $2 $3
    create_deployment $1
}

# $1: namespace
# $2: service name
function is_service_created()
{
    echo "start is service created"

    kubectl get --namespace=$1 svc/$2

    if [ $? -eq 0 ]; then
        echo "finish is service created return 1"
        return 1
    else
        echo "finish is service created return 0"
        return 0
    fi
}

# $1: yaml path
function create_service()
{
    echo "start create service"

    kubectl create -f $1

    if [ $? -eq 0 ]; then
        echo "finish create service with return 1"
        return 1
    else
        echo "finish create service with return 0"
        return 0
    fi
}

# $1: namespace
# $2: service name
function delete_service()
{
    echo "start delete service"

    kubectl delete --namespace=$1 svc/$2

    if [ $? -eq 0 ]; then
        echo "finish delete service with return 1"
        return 1
    else
        echo "finish delete service with return 0"
        return 0
    fi
}

# $1: yaml path
# $2: namespace
# $3: service name
function update_service()
{
    delete_service $2 $3
    create_service $1

}

echo "start update service"

# update service
update_service 'kube/service.yaml' 'passport' 'admin-web'

echo "finish update service"


echo "start update deployment"

# update deployment
update_deployment 'kube/deployment.yaml' 'passport' 'admin-web'

echo "finish update deployment"
