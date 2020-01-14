FROM gradle:4.10.2-jdk-alpine
add --chown=gradle . /code
WORKDIR /code
CMD gradle run
