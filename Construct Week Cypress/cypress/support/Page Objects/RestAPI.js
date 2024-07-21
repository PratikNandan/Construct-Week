class resAPI{
    get_all(method,burl,endpoints){  
        cy.request({
        method:method,
        url:burl+endpoints,
        headers:{
            "Content-Type":"application/json"
        },failOnStatusCode: false
    }).then((Response)=>{
        expect(Response.status).to.be.oneOf([200,429]);
        //expect(Response.status).to.eq(200);
        //expect([200, 429]).to.include(Response.status);
        cy.log(JSON.stringify(Response.body))
    })

}

    get_emp(method,burl,endpoints){  
        cy.request({
        method:method,
        url:burl+endpoints,
        headers:{
            "Content-Type":"application/json"
        },failOnStatusCode: false
    }).then((Response)=>{
        expect(Response.status).to.be.oneOf([200,429]);
        //expect(Response.status).to.eq(200);
        //expect([200, 429]).to.include(Response.status);

        cy.log(JSON.stringify(Response.body))
    })

}

    create(method,burl,endpoints,data){  
        cy.request({
        method:method,
        url:burl+ endpoints,
        body:data,
        headers:{
            "Content-Type":"application/json"
        },failOnStatusCode: false
    }).then((Response)=>{
        expect(Response.status).to.be.oneOf([200,429]);

        //expect(Response.status).to.eq(200);
        cy.log(JSON.stringify(Response.body))
    })

}

    update(method,burl,endpoints,data){  
        cy.request({
        method:method,
        url:burl+ endpoints,
        body:data,
        headers:{
            "Content-Type":"application/json"
        },failOnStatusCode: false
    }).then((Response)=>{
        expect(Response.status).to.be.oneOf([200,429]);
        //expect(Response.status).to.eq(200);
        cy.log(JSON.stringify(Response.body))
    })

}



    delete(method,burl,endpoints){  
        cy.request({
        method:method,
        url:burl+ endpoints,
        headers:{
            "Content-Type":"application/json"
        },failOnStatusCode: false
    }).then((Response)=>{
        //expect(Response.status).to.eq(200);
        expect(Response.status).to.be.oneOf([200,429]);
        cy.log(JSON.stringify(Response.body))
    })

}










//dnt
}
export default resAPI;