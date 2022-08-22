import React, {useEffect, useState} from 'react';
import GamesCategory from "../components/GamesCategory";
import MainLayout from "../components/layouts/MainLayout";
import {IGames} from "../models/Games";
import {BASE_SERVER_URL} from "../constants/baseServerURL";

const Games = () => {
    const [games, setGames] = useState(Array<IGames>)
    useEffect(() => {
        const url = `${BASE_SERVER_URL}/games/getAll`
        fetch(url)
            .then(response => response.json())
            .then(json => setGames(json))
    }, [])
    return (
        <MainLayout>
            <GamesCategory title={"Популярные"} games={games}/>
            <GamesCategory title={"Распродажа"} games={games}/>
            <GamesCategory title={"Новинки"} games={games}/>
        </MainLayout>
    );
};

export default Games;