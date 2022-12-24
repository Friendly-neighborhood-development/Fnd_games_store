import React, {FC, useEffect} from 'react';
import axios from "axios";

export const Test:FC = () => {
    useEffect(()=> {
        const auth = async () => {
            const res = await axios.post("http://localhost:8080/login/v1/authorization", {
                username: "admin",
                password: "password"
            })
            console.log(res.data)
        }
        auth()
    })
    return(
        <div>
            
        </div>
    )
}