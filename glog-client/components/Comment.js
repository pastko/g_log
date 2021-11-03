import React from 'react'


function Comment({item: {id, email, body}}) {
    return (
        <div>
            <div className="content" style={{ height:500,width:350,float:'left'}}>
                <div className="content-body" 
                style={{textAlign:'center',padding:60,paddingLeft: 2,paddingRight: 2,border: 2,borderStyle:'solid',margin:50,float:'left',height:320}}>
                <h5 className="content-title">Id : {id}</h5>
                <h6 className="content-subtitle">Email : {email}</h6>
                <p className="content-text">Comment : {body}</p>
                </div>
            </div>
        </div>
    )
}


export default Comment