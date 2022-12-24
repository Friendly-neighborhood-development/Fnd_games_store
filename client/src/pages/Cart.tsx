import React, {useEffect} from 'react';
import MainLayout from "../components/layouts/MainLayout";
import {useAppDispatch} from "../hooks/redux";
import {auth} from "../store/actions/authAction";

const Cart = () => {
    const dispatch = useAppDispatch()
    useEffect(() => {
        // hardcode admin data
        dispatch(auth({username: "admin", password: "password"}))
    }, [])
    return (
        <MainLayout>
            Cart
        </MainLayout>
    );
};

export default Cart;