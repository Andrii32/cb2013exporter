
## Scala learning project
Loads data from crunchabse2013snapshot database into elasticsearch

## TODO

* Handle errors the right way
* Add Dockerfile
* Add tests
* Add CI using Github Actions
* Load data in a few parallel streams
* Use Refined types to validate configs
* `Maybe` Add other sinks, like MinIO/Mongo


## Crunchbase 2013 Snapshot

[Crunchbase 2013 Snapshot © 2013](https://data.crunchbase.com/docs/2013-snapshot?utm_content=data_accept_basic&utm_campaign=none&utm_source=none&utm_medium=email)

Download archive and unpack it into `./crunchbase2013db` folder.

    /crunchbase2013db
        /crunchabse_2013_snapchot_20131212

Check if user with UID exists

    List users: cat /etc/passwd
    Change UID: usermod  -u <NEW_UID> <USERNAME>
    Change GID: groupmod -g <NEW_GID> <USERNAME>

Create user with 999 UID:GID if not exists

    useradd -u 999 mysql

Change crunchabse_2013_snapshot_20131212 owner

    sudo chown -R 999:999 ./crunchbase2013db/crunchbase_2013_snapshot_20131212
    sudo chown -R 999:999 ./crunchbase2013db/logs

## MYSQL Helpers

Connect to mysql

     mysql -u <USERNAME> -p
     Enter password: <PASSWORD>

Show databases

    show databases;

Use database

    use <DB_NAME>;

Show tables

    show tables;

Describe table:

    describe <TABLE_NAME>;

