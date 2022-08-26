import React, {FC, memo, useEffect, useState} from 'react';
import MainLayout from "../components/layouts/MainLayout";


const Test: FC = memo(() => {
    return (
        <MainLayout>
            <div className={"w-72 h-72 rounded-lg dark:bg-slate-800 p-4"}>
                <blockquote className="text-2xl font-semibold italic text-center text-slate-900">
                    When you look
                    <span
                        className={"before:block before:absolute before:-inset-1 before:-skew-y-3 before:bg-pink-500 relative inline-block"}>
                        <span className={" text-white"}>
                            losos
                        </span>
                </span>
                    all the time, people think that you're busy.
                </blockquote>
            </div>
        </MainLayout>
    );
});

export default Test;