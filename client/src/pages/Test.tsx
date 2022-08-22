import React, {memo, useState} from 'react';
import MainLayout from "../components/layouts/MainLayout";
import {useDispatch, useSelector} from "react-redux";
import {RootState} from "../store/store";
import Button from "../components/UI/Button";
import {decrement, increment, incrementByAmount} from "../store/reducers/counterSlice";
import Input from "../components/UI/Input";

const Test = memo(() => {
    const [amountValue, setAmountValue] = useState("")
    const count = useSelector((state: RootState) => state.counter.value)
    const dispatch = useDispatch()
    return (
        <MainLayout>
            <div className={"flex flex-col justify-items-start"}>
                <h1>Here is count: {count}</h1>
                <Button
                    onClick={() => dispatch(increment())}
                    className={"bg-green-600"}
                >
                    Increment
                </Button>
                <Button
                    onClick={() => dispatch(decrement())}
                    className={"bg-pink-600"}
                >
                    Decrement
                </Button>
                <Input
                    type={"text"}
                    value={amountValue}
                    onChange={(e: React.FormEvent<HTMLInputElement>) => setAmountValue(e.currentTarget.value)}
                    className={"dark:bg-slate-800"}
                    label={"amount"}
                />
                <Button
                    onClick={() => dispatch(incrementByAmount(+amountValue))}
                    className={"bg-sky-600"}
                >
                    Increment by amount
                </Button>
            </div>


        </MainLayout>
    );
});

export default Test;