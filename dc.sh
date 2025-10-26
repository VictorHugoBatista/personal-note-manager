#/bin/bash
command=$1

cd infra

case "$command" in
    up)
        docker-compose up -d
        ;;
    down)
        docker-compose down
        ;;
    *)
    echo "Unavailable option"
    ;;
esac

cd -
