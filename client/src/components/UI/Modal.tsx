import React, { FC, Fragment, useState } from 'react';
import { Dialog, Transition } from '@headlessui/react';
import { PrimaryButton } from './PrimaryButton';
import { SecondaryButton } from './SecondaryButton';

interface ModalProps {
    children: React.ReactNode;
    isOpen: boolean;
    onClose: (arg0: boolean) => void;
    title?: string;
    buttonTitle?: string;
}

export const Modal: FC<ModalProps> = ({
    children,
    isOpen,
    onClose,
    title,
    buttonTitle,
}) => {
    return (
        <>
            <Transition appear show={isOpen} as={Fragment}>
                <Dialog as="div" className="relative z-10" onClose={onClose}>
                    <Transition.Child
                        as={Fragment}
                        enter="ease-out duration-300"
                        enterFrom="opacity-0"
                        enterTo="opacity-100"
                        leave="ease-in duration-200"
                        leaveFrom="opacity-100"
                        leaveTo="opacity-0"
                    >
                        <div className="fixed inset-0 bg-black bg-opacity-25 backdrop-blur-sm" />
                    </Transition.Child>

                    <div className="fixed inset-0 overflow-y-auto">
                        <div className="flex min-h-full items-center justify-center p-4 text-center">
                            <Transition.Child
                                as={Fragment}
                                enter="ease-out duration-300"
                                enterFrom="opacity-0 scale-95"
                                enterTo="opacity-100 scale-100"
                                leave="ease-in duration-200"
                                leaveFrom="opacity-100 scale-100"
                                leaveTo="opacity-0 scale-95"
                            >
                                <Dialog.Panel className="text-slate-900 w-full max-w-md transform overflow-hidden rounded-2xl bg-white p-6 text-left align-middle shadow-xl transition-all dark:bg-slate-800 dark:text-slate-200">
                                    <Dialog.Title
                                        as="h3"
                                        className="text-xl font-medium leading-6"
                                    >
                                        {title}
                                    </Dialog.Title>
                                    <div className="mt-2">{children}</div>

                                    {buttonTitle && (
                                        <div className="mt-4">
                                            <SecondaryButton
                                                type="button"
                                                onClick={onClose}
                                            >
                                                {buttonTitle}
                                            </SecondaryButton>
                                        </div>
                                    )}
                                </Dialog.Panel>
                            </Transition.Child>
                        </div>
                    </div>
                </Dialog>
            </Transition>
        </>
    );
};
