package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return hat by id=1"

    request {
        url "/hat/1"
        method GET()
    }

    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body (
                id: 1,
                name: "Test Hat 1",
                size: 10,
                color: "striped"
        )
    }

}
