import React, {memo, useEffect} from 'react';
import MainLayout from "../components/layouts/MainLayout";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {fetchGames} from "../store/actions/gameAction";
import GamesCategory from "../components/GamesCategory";

const Test = memo(() => {
    const {games, isLoading, error} = useAppSelector(state => state.game)
    const dispatch = useAppDispatch()

    useEffect(() => {
        dispatch(fetchGames())
    }, [])
    if(isLoading){
        return(
            <MainLayout>
                <h1>Идёт загрузка..</h1>
            </MainLayout>
        )
    }
    if(error)
        return (
            <MainLayout>
                <h1>{error}</h1>
            </MainLayout>
        )
    return (
        <MainLayout>

            <GamesCategory title={"Популярные"} type={"popular"} games={games}/>
            <GamesCategory title={"Распродажа"} type={"sale"} games={games}/>
            <GamesCategory title={"Новинки"} type={"new"} games={games}/>
        </MainLayout>
    );
});

export default Test;