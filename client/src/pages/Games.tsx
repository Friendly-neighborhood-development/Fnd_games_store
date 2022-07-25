import React, {useEffect, useState} from 'react';
import GamesCategory from "../components/GamesCategory";
import MainLayout from "../components/layouts/MainLayout";
import {gameProps} from "../types/Games";
import {BASE_URL} from "../constants/baseURL";

const Games = () => {
    const [games, setGames] = useState(Array<gameProps>)
    useEffect(() => {
        const url = `${BASE_URL}/games/getAll`
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