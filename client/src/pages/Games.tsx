import React, {useEffect} from 'react';
import GamesCategory from "../components/GamesCategory";
import MainLayout from "../components/layouts/MainLayout";
import {useAppDispatch, useAppSelector} from "../hooks/redux";

const Games = () => {
    const {games, isLoading, error} = useAppSelector(state => state.game)

    return (
        <MainLayout>
            <div className={"w-full flex flex-col"}>
                <GamesCategory title={"Популярные"} type={"popular"} games={games} isLoading={isLoading} error={error}/>
                <GamesCategory title={"Распродажа"} type={"sale"} games={games} isLoading={isLoading} error={error}/>
                <GamesCategory title={"Новинки"} type={"new"} games={games} isLoading={isLoading} error={error}/>
            </div>
        </MainLayout>
    );
};

export default Games;