import React, { useState } from 'react';
import { useAppSelector } from '../../hooks/redux';
import { PrimaryButton } from '../UI/PrimaryButton';
import { BoltIcon } from '@heroicons/react/20/solid';
import { Modal } from '../UI/Modal';

export const CartOrderBlock = () => {
    const { games } = useAppSelector((state) => state.cart);
    const [modalVisible, setModalVisible] = useState(false);

    return (
        <div className="md:w-2/5 md:ml-10 mt-8 md:mt-0">
            <div className="rounded-lg bg-gray-200/50 mb-4 p-4 space-y-1 dark:bg-slate-800">
                <div className="flex justify-between items-end mb-2">
                    <div className="text-lg">Total:</div>
                    <div className="text-xl">
                        {games
                            .reduce(
                                (acc, cur) =>
                                    acc +
                                    cur.price -
                                    (cur.price * cur.discount) / 100,
                                0
                            )
                            .toFixed(2)}
                        <span className="text-base">&#8381;</span>
                    </div>
                </div>
                <div className="text-sm flex justify-between">
                    <div>Games count: {games.length}</div>
                    <div>
                        {games
                            .reduce((acc, cur) => acc + cur.price, 0)
                            .toFixed(2)}
                        &#8381;
                    </div>
                </div>
                <div className="text-sm flex justify-between">
                    <div>Discount:</div>
                    <div className="text-red-400">
                        {games
                            .reduce(
                                (acc, cur) =>
                                    acc + (cur.discount * cur.price) / 100,
                                0
                            )
                            .toFixed(2)}
                        &#8381;
                    </div>
                </div>
            </div>
            <PrimaryButton
                type={'submit'}
                onClick={() => setModalVisible(true)}
            >
                Place order
                <BoltIcon className={'w-4 h-4 ml-2'} />
            </PrimaryButton>
            {modalVisible && (
                <Modal
                    isOpen={modalVisible}
                    setIsOpen={setModalVisible}
                    buttonTitle="Got it, thanks!"
                    title="Payment successful"
                >
                    <div className="text-slate-900/80 mt-4 dark:text-slate-200/80">
                        Thank you for your order. Now your games will be
                        available in the{' '}
                        <span className="text-blue-600 cursor-pointer dark:text-sky-400 hover:underline">
                            library
                        </span>
                    </div>
                </Modal>
            )}
        </div>
    );
};
