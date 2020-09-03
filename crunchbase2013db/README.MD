## DB Schema description

### Databases

    show databases;

    +------------------------+
    | Database               |
    +------------------------+
    | information_schema     |
    | crunchbase2013snapshot |
    +------------------------+
    2 rows in set (0.00 sec)

### Tables

    show tables;

    +----------------------------------+
    | Tables_in_crunchbase2013snapshot |
    +----------------------------------+
    | cb_acquisitions                  |
    | cb_degrees                       |
    | cb_funding_rounds                |
    | cb_funds                         |
    | cb_investments                   |
    | cb_ipos                          |
    | cb_milestones                    |
    | cb_objects                       |
    | cb_offices                       |
    | cb_people                        |
    | cb_relationships                 |
    +----------------------------------+
    11 rows in set (0.00 sec)

### `cb_acquisitions`

    describe cb_acquisitions;

    +---------------------+---------------+------+-----+---------+-------+
    | Field               | Type          | Null | Key | Default | Extra |
    +---------------------+---------------+------+-----+---------+-------+
    | id                  | bigint(20)    | NO   | PRI | NULL    |       |
    | acquisition_id      | bigint(20)    | NO   | MUL | NULL    |       |
    | acquiring_object_id | varchar(64)   | NO   | MUL | NULL    |       |
    | acquired_object_id  | varchar(64)   | NO   | MUL | NULL    |       |
    | term_code           | varchar(16)   | YES  |     | NULL    |       |
    | price_amount        | decimal(15,0) | YES  |     | NULL    |       |
    | price_currency_code | varchar(16)   | YES  |     | NULL    |       |
    | acquired_at         | date          | YES  |     | NULL    |       |
    | source_url          | varchar(255)  | YES  |     | NULL    |       |
    | source_description  | varchar(255)  | YES  |     | NULL    |       |
    | created_at          | datetime      | YES  |     | NULL    |       |
    | updated_at          | datetime      | YES  |     | NULL    |       |
    +---------------------+---------------+------+-----+---------+-------+
    12 rows in set (0.00 sec)

Relations:

    cb_acquisitions.acquiring_object_id -> cb_objects.id
    cb_acquisitions.acquired_object_id  -> cb_objects.id

### `cb_degrees`

    describe cb_degrees;

    +--------------+--------------+------+-----+---------+-------+
    | Field        | Type         | Null | Key | Default | Extra |
    +--------------+--------------+------+-----+---------+-------+
    | id           | bigint(20)   | NO   | PRI | NULL    |       |
    | object_id    | varchar(64)  | NO   | MUL | NULL    |       |
    | degree_type  | varchar(32)  | NO   |     | NULL    |       |
    | subject      | varchar(255) | YES  |     | NULL    |       |
    | institution  | varchar(64)  | YES  |     | NULL    |       |
    | graduated_at | date         | YES  |     | NULL    |       |
    | created_at   | datetime     | YES  |     | NULL    |       |
    | updated_at   | datetime     | YES  |     | NULL    |       |
    +--------------+--------------+------+-----+---------+-------+
    8 rows in set (0.00 sec)

Relations:

    cb_degrees.object_id -> cb_objects.id

### `cb_funding_rounds`

    describe cb_funding_rounds;

    +--------------------------+---------------+------+-----+---------+-------+
    | Field                    | Type          | Null | Key | Default | Extra |
    +--------------------------+---------------+------+-----+---------+-------+
    | id                       | bigint(20)    | NO   | PRI | NULL    |       |
    | funding_round_id         | bigint(20)    | NO   | MUL | NULL    |       |
    | object_id                | varchar(64)   | NO   | MUL | NULL    |       |
    | funded_at                | date          | YES  |     | NULL    |       |
    | funding_round_type       | varchar(32)   | YES  |     | NULL    |       |
    | funding_round_code       | varchar(32)   | YES  |     | NULL    |       |
    | raised_amount_usd        | decimal(15,0) | YES  |     | NULL    |       |
    | raised_amount            | decimal(15,0) | YES  |     | NULL    |       |
    | raised_currency_code     | varchar(3)    | YES  |     | NULL    |       |
    | pre_money_valuation_usd  | decimal(15,0) | YES  |     | NULL    |       |
    | pre_money_valuation      | decimal(15,0) | YES  |     | NULL    |       |
    | pre_money_currency_code  | varchar(3)    | YES  |     | NULL    |       |
    | post_money_valuation_usd | decimal(15,0) | YES  |     | NULL    |       |
    | post_money_valuation     | decimal(15,0) | YES  |     | NULL    |       |
    | post_money_currency_code | varchar(3)    | YES  |     | NULL    |       |
    | participants             | int(11)       | YES  |     | NULL    |       |
    | is_first_round           | int(11)       | YES  |     | 0       |       |
    | is_last_round            | int(11)       | YES  |     | 0       |       |
    | source_url               | varchar(255)  | YES  |     | NULL    |       |
    | source_description       | varchar(255)  | YES  |     | NULL    |       |
    | created_by               | varchar(64)   | YES  |     | NULL    |       |
    | created_at               | datetime      | YES  |     | NULL    |       |
    | updated_at               | datetime      | YES  |     | NULL    |       |
    +--------------------------+---------------+------+-----+---------+-------+
    23 rows in set (0.00 sec)

Relations:

    cb_funding_rounds.object_id -> cb_objects.id

### `cb_funds`

    describe cb_funds;

    +----------------------+---------------+------+-----+---------+-------+
    | Field                | Type          | Null | Key | Default | Extra |
    +----------------------+---------------+------+-----+---------+-------+
    | id                   | bigint(20)    | NO   | PRI | NULL    |       |
    | fund_id              | bigint(20)    | NO   | MUL | NULL    |       |
    | object_id            | varchar(64)   | NO   | MUL | NULL    |       |
    | name                 | varchar(255)  | NO   |     | NULL    |       |
    | funded_at            | date          | YES  |     | NULL    |       |
    | raised_amount        | decimal(15,0) | YES  |     | NULL    |       |
    | raised_currency_code | varchar(3)    | YES  |     | NULL    |       |
    | source_url           | varchar(255)  | YES  |     | NULL    |       |
    | source_description   | varchar(255)  | YES  |     | NULL    |       |
    | created_at           | datetime      | YES  |     | NULL    |       |
    | updated_at           | datetime      | YES  |     | NULL    |       |
    +----------------------+---------------+------+-----+---------+-------+
    11 rows in set (0.01 sec)

Relations:

    cb_funds.object_id -> cb_objects.id

### `cb_investments`

    describe cb_investments;

    +--------------------+-------------+------+-----+---------+-------+
    | Field              | Type        | Null | Key | Default | Extra |
    +--------------------+-------------+------+-----+---------+-------+
    | id                 | bigint(20)  | NO   | PRI | NULL    |       |
    | funding_round_id   | bigint(20)  | NO   | MUL | NULL    |       |
    | funded_object_id   | varchar(64) | NO   | MUL | NULL    |       |
    | investor_object_id | varchar(64) | NO   | MUL | NULL    |       |
    | created_at         | datetime    | YES  |     | NULL    |       |
    | updated_at         | datetime    | YES  |     | NULL    |       |
    +--------------------+-------------+------+-----+---------+-------+
    6 rows in set (0.00 sec)

Relations:

    cb_investments.funding_round_id    -> cb_funding_rounds.id
    cb_investments.funded_object_id    -> cb_objects.id
    cb_investments.investor_object_id  -> cb_objects.id


### `cb_ipos`

    describe cb_ipos;

    +-------------------------+---------------+------+-----+---------+-------+
    | Field                   | Type          | Null | Key | Default | Extra |
    +-------------------------+---------------+------+-----+---------+-------+
    | id                      | bigint(20)    | NO   | PRI | NULL    |       |
    | ipo_id                  | bigint(20)    | NO   |     | NULL    |       |
    | object_id               | varchar(64)   | NO   | MUL | NULL    |       |
    | valuation_amount        | decimal(15,0) | YES  |     | NULL    |       |
    | valuation_currency_code | varchar(16)   | YES  |     | NULL    |       |
    | raised_amount           | decimal(15,0) | YES  |     | NULL    |       |
    | raised_currency_code    | varchar(16)   | YES  |     | NULL    |       |
    | public_at               | date          | YES  |     | NULL    |       |
    | stock_symbol            | varchar(32)   | YES  |     | NULL    |       |
    | source_url              | varchar(255)  | YES  |     | NULL    |       |
    | source_description      | varchar(255)  | YES  |     | NULL    |       |
    | created_at              | datetime      | YES  |     | NULL    |       |
    | updated_at              | datetime      | YES  |     | NULL    |       |
    +-------------------------+---------------+------+-----+---------+-------+
    13 rows in set (0.01 sec)

Relations:

    cb_ipos.object_id -> cb_objects.id


### `cb_milestones`

    describe cb_milestones;

    +--------------------+--------------+------+-----+---------+-------+
    | Field              | Type         | Null | Key | Default | Extra |
    +--------------------+--------------+------+-----+---------+-------+
    | id                 | bigint(20)   | NO   | PRI | NULL    |       |
    | object_id          | varchar(64)  | NO   | MUL | NULL    |       |
    | milestone_at       | date         | YES  |     | NULL    |       |
    | milestone_code     | varchar(32)  | YES  |     | NULL    |       |
    | description        | varchar(255) | YES  |     | NULL    |       |
    | source_url         | varchar(255) | YES  |     | NULL    |       |
    | source_description | varchar(255) | YES  |     | NULL    |       |
    | created_at         | datetime     | YES  |     | NULL    |       |
    | updated_at         | datetime     | YES  |     | NULL    |       |
    +--------------------+--------------+------+-----+---------+-------+
    9 rows in set (0.01 sec)

Relations:

    cb_milestones.object_id -> cb_objects.id


### `cb_objects`

    describe cb_objects;

    +---------------------+---------------+------+-----+-----------+-------+
    | Field               | Type          | Null | Key | Default   | Extra |
    +---------------------+---------------+------+-----+-----------+-------+
    | id                  | varchar(64)   | NO   | PRI | NULL      |       |
    | entity_type         | varchar(16)   | NO   | MUL | NULL      |       |
    | entity_id           | bigint(20)    | NO   |     | NULL      |       |
    | parent_id           | varchar(64)   | YES  |     | NULL      |       |
    | name                | varchar(255)  | NO   | MUL | NULL      |       |
    | normalized_name     | varchar(255)  | NO   | MUL | NULL      |       |
    | permalink           | varchar(255)  | NO   | MUL | NULL      |       |
    | category_code       | varchar(32)   | YES  |     | NULL      |       |
    | status              | varchar(32)   | YES  |     | operating |       |
    | founded_at          | date          | YES  |     | NULL      |       |
    | closed_at           | date          | YES  |     | NULL      |       |
    | domain              | varchar(64)   | YES  | MUL | NULL      |       |
    | homepage_url        | varchar(64)   | YES  |     | NULL      |       |
    | twitter_username    | varchar(64)   | YES  |     | NULL      |       |
    | logo_url            | varchar(255)  | YES  |     | NULL      |       |
    | logo_width          | int(11)       | YES  |     | NULL      |       |
    | logo_height         | int(11)       | YES  |     | NULL      |       |
    | short_description   | varchar(255)  | YES  |     | NULL      |       |
    | description         | varchar(255)  | YES  |     | NULL      |       |
    | overview            | text          | YES  |     | NULL      |       |
    | tag_list            | varchar(255)  | YES  |     | NULL      |       |
    | country_code        | varchar(64)   | YES  |     | NULL      |       |
    | state_code          | varchar(64)   | YES  |     | NULL      |       |
    | city                | varchar(64)   | YES  |     | NULL      |       |
    | region              | varchar(255)  | YES  |     | NULL      |       |
    | first_investment_at | date          | YES  |     | NULL      |       |
    | last_investment_at  | date          | YES  |     | NULL      |       |
    | investment_rounds   | int(11)       | YES  |     | NULL      |       |
    | invested_companies  | int(11)       | YES  |     | NULL      |       |
    | first_funding_at    | date          | YES  |     | NULL      |       |
    | last_funding_at     | date          | YES  |     | NULL      |       |
    | funding_rounds      | int(11)       | YES  |     | NULL      |       |
    | funding_total_usd   | decimal(15,0) | YES  |     | NULL      |       |
    | first_milestone_at  | date          | YES  |     | NULL      |       |
    | last_milestone_at   | date          | YES  |     | NULL      |       |
    | milestones          | int(11)       | YES  |     | NULL      |       |
    | relationships       | int(11)       | YES  |     | NULL      |       |
    | created_by          | varchar(64)   | YES  |     | NULL      |       |
    | created_at          | datetime      | YES  |     | NULL      |       |
    | updated_at          | datetime      | YES  |     | NULL      |       |
    +---------------------+---------------+------+-----+-----------+-------+
    40 rows in set (0.00 sec)

Relations:

    cb_objects.parent_id -> cb_objects.id


### `cb_offices`

    describe cb_offices;

    +--------------+----------------+------+-----+---------+-------+
    | Field        | Type           | Null | Key | Default | Extra |
    +--------------+----------------+------+-----+---------+-------+
    | id           | bigint(20)     | NO   | PRI | NULL    |       |
    | object_id    | varchar(64)    | NO   | MUL | NULL    |       |
    | office_id    | bigint(20)     | NO   |     | NULL    |       |
    | description  | varchar(255)   | YES  |     | NULL    |       |
    | region       | varchar(255)   | YES  |     | NULL    |       |
    | address1     | varchar(255)   | YES  |     | NULL    |       |
    | address2     | varchar(255)   | YES  |     | NULL    |       |
    | city         | varchar(255)   | YES  |     | NULL    |       |
    | zip_code     | varchar(255)   | YES  |     | NULL    |       |
    | state_code   | varchar(3)     | YES  |     | NULL    |       |
    | country_code | varchar(3)     | YES  |     | NULL    |       |
    | latitude     | decimal(15,10) | YES  |     | NULL    |       |
    | longitude    | decimal(15,10) | YES  |     | NULL    |       |
    | created_at   | datetime       | YES  |     | NULL    |       |
    | updated_at   | datetime       | YES  |     | NULL    |       |
    +--------------+----------------+------+-----+---------+-------+
    15 rows in set (0.00 sec)

Relations:

    cb_offices.object_id -> cb_objects.id


### `cb_people`

    describe cb_people;

    +------------------+--------------+------+-----+---------+-------+
    | Field            | Type         | Null | Key | Default | Extra |
    +------------------+--------------+------+-----+---------+-------+
    | id               | bigint(20)   | NO   | PRI | NULL    |       |
    | object_id        | varchar(64)  | NO   | UNI | NULL    |       |
    | first_name       | varchar(128) | NO   |     | NULL    |       |
    | last_name        | varchar(128) | NO   |     | NULL    |       |
    | birthplace       | varchar(128) | YES  |     | NULL    |       |
    | affiliation_name | varchar(128) | YES  |     | NULL    |       |
    +------------------+--------------+------+-----+---------+-------+
    6 rows in set (0.00 sec)

Relations:

    cb_people.object_id -> cb_objects.id


### `cb_relationships`

    describe cb_relationships;

    +------------------------+--------------+------+-----+---------+-------+
    | Field                  | Type         | Null | Key | Default | Extra |
    +------------------------+--------------+------+-----+---------+-------+
    | id                     | bigint(20)   | NO   | PRI | NULL    |       |
    | relationship_id        | bigint(20)   | NO   |     | NULL    |       |
    | person_object_id       | varchar(64)  | NO   | MUL | NULL    |       |
    | relationship_object_id | varchar(64)  | NO   | MUL | NULL    |       |
    | start_at               | date         | YES  |     | NULL    |       |
    | end_at                 | date         | YES  |     | NULL    |       |
    | is_past                | tinyint(4)   | YES  |     | NULL    |       |
    | sequence               | int(11)      | YES  |     | 0       |       |
    | title                  | varchar(255) | YES  |     | NULL    |       |
    | created_at             | datetime     | YES  |     | NULL    |       |
    | updated_at             | datetime     | YES  |     | NULL    |       |
    +------------------------+--------------+------+-----+---------+-------+
    11 rows in set (0.00 sec)

Relations:

    cb_relationships.person_object_id       -> cb_objects.id
    cb_relationships.relationship_object_id -> cb_objects.id