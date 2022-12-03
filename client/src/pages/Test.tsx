import React, {FC, Fragment, memo, useEffect, useState} from 'react';
import MainLayout from "../components/layouts/MainLayout";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import GamesCategory from "../components/GamesCategory";
import {login} from "../store/actions/authAction";
import axios from "axios";
import {BASE_API_URL} from "../constants/baseApiURL";
import {IGame} from "../models/IGame";
import {fetchGames} from "../store/actions/gameAction";
import Cart from "../components/Cart/Cart";
import { Dialog, Transition } from '@headlessui/react';

const Test: FC = memo(() => {
    const {isLoading, error} = useAppSelector(state => state.auth)
    const dispatch = useAppDispatch()

    //

    // const fetchData = async () => {
    //     await dispatch(login("admin", "password"))
    //     // const res = await axios.get<IGame[]>(
    //     //     `${BASE_API_URL}/games/getAll`,
    //     //     {headers: {Authorization: "Bearer " + localStorage.getItem("token")}}
    //     // )
    // }

    useEffect( () => {
        const fetchData = async () => {
            console.log(localStorage.token + " - 1");
            // await login("admin", "password")
            await dispatch(login("admin", "password"))
            console.log(localStorage.token + " - 2");
            const res = await axios.get<IGame[]>(
                `${BASE_API_URL}/games/getAll`,
                {headers: {Authorization: "Bearer " + localStorage.getItem("token")}}
            )
            console.log("Сейчас запрос по адресу /games /getAll");
            console.log(res.data);
        }
        fetchData()

    }, [])


    return (
        <MainLayout>
        </MainLayout>
    );
});

export default Test;