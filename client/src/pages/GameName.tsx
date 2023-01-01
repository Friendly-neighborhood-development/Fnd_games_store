import React, {useEffect} from 'react';
import MainLayout from "../components/layouts/MainLayout";
import {useNavigate, useParams} from "react-router-dom";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {fetchOneGame} from "../store/actions/gameAction";

const GameName = () => {
    const {name} = useParams()
    const navigate = useNavigate()

    const dispatch = useAppDispatch()
    const {game, loading, error} = useAppSelector((state) => state.game)
    useEffect(() => {
        if (!name) navigate("/error")
        else dispatch(fetchOneGame(name))
    }, [])

    if(loading === "failed"){
        navigate("/error")
    }

    return (
        <MainLayout>
            <h1 className={"text-3xl"}>{game.name}</h1>
            <img src={game.base64Image}/>
        </MainLayout>
    );
};

export default GameName;